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
    private final BCryptPasswordEncoder encoder;

    @Override
    public AuthResponse register(RegisterDTO registerDTO) {
        User user = new User();
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setUsername(registerDTO.getEmail());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(encoder.encode(registerDTO.getPassword()));
        user.setPassportNumber(registerDTO.getPassportNumber());
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
        UserDetails user = usersRepository.findByUsername(loginDTO.getEmail()).orElseThrow(() -> new RuntimeException("Invalid credentials"));
        
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }
}