package ua.tqs.airportManager.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ua.tqs.airportManager.Jwt.JwtService;
import ua.tqs.airportManager.dto.AuthResponse;
import ua.tqs.airportManager.dto.LoginDTO;
import ua.tqs.airportManager.dto.RegisterDTO;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.UserRepository;
import ua.tqs.airportManager.Roles;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private AuthServiceImpl authService;

    private User user;
    private RegisterDTO registerDTO;
    private LoginDTO loginDTO;

    @BeforeEach
    void setUp() {
        user = new User("john.doe", "John", "Doe", "password", "john.doe@example.com", "A1234567", "New York", "USA", Roles.USER);
        registerDTO = new RegisterDTO("john.doe@example.com", "John", "Doe", "password", "john.doe@example.com", "A1234567", "New York", "USA");
        loginDTO = new LoginDTO("john.doe@example.com", "password");
    }

    @Test
    void testRegister() {
        when(bCryptPasswordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(jwtService.getToken(any(UserDetails.class))).thenReturn("token");

        AuthResponse response = authService.register(registerDTO);

        assertThat(response).isNotNull();
        assertThat(response.getToken()).isEqualTo("token");

        verify(userRepository).save(any(User.class));
    }

    @Test
    void testLogin() {
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(null);
        when(userRepository.findByUsername(any(String.class))).thenReturn(Optional.of(user));
        when(jwtService.getToken(any(UserDetails.class))).thenReturn("token");

        AuthResponse response = authService.login(loginDTO);

        assertThat(response).isNotNull();
        assertThat(response.getToken()).isEqualTo("token");

        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(userRepository).findByUsername(any(String.class));
    }

}
