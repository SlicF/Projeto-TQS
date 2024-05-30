package ua.tqs.airportManager.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ua.tqs.airportManager.Roles;
import ua.tqs.airportManager.Jwt.JwtService;
import ua.tqs.airportManager.dto.AuthResponse;
import ua.tqs.airportManager.dto.LoginDTO;
import ua.tqs.airportManager.dto.RegisterDTO;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.UserRepository;
import ua.tqs.airportManager.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository usersRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterDTO registerDTO) {
        
        User user = new User();
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setUsername(registerDTO.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(registerDTO.getUserPassword());
        user.setPassword(encodedPassword);
        user.setCity(registerDTO.getCity());
        user.setCountry(registerDTO.getCountry());
        user.setRole(Roles.USER);

    
        usersRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

    @Override
    public AuthResponse login(LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        UserDetails user = usersRepository.findByUsername(loginDTO.getEmail()).orElseThrow();
        
        if (user == null) {
            System.out.println("Invalid credentials");
            throw new RuntimeException("Invalid credentials");
        }
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (encoder.matches(loginDTO.getPassword(), user.getPassword())) {
            String token = jwtService.getToken(user);
            
            System.out.println(AuthResponse.builder()
                .token(token)
                .build());
            
            return AuthResponse.builder()
                .token(token)
                .build();
        } else {
            System.out.println("Invalid credentials");
            throw new RuntimeException("Invalid credentials");
        }
        
    }
}
