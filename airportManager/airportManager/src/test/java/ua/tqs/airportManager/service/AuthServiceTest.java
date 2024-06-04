package ua.tqs.airportManager.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.tqs.airportManager.dto.AuthResponse;
import ua.tqs.airportManager.dto.LoginDTO;
import ua.tqs.airportManager.dto.RegisterDTO;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private AuthService authService;

    private RegisterDTO registerDTO;
    private LoginDTO loginDTO;
    private AuthResponse authResponse;

    @BeforeEach
    void setUp() {
        registerDTO = new RegisterDTO("john.doe@example.com", "password", "John", "Doe", "1234567890", "City", "Country", "Passport");
        loginDTO = new LoginDTO("john.doe@example.com", "password");
        authResponse = new AuthResponse("dummyToken");
    }

    @Test
    void testRegister() {
        when(authService.register(any(RegisterDTO.class))).thenReturn(authResponse);

        AuthResponse response = authService.register(registerDTO);

        assertThat(response).isNotNull();
        assertThat(response.getToken()).isEqualTo("dummyToken");
    }

    @Test
    void testLogin() {
        when(authService.login(any(LoginDTO.class))).thenReturn(authResponse);

        AuthResponse response = authService.login(loginDTO);

        assertThat(response).isNotNull();
        assertThat(response.getToken()).isEqualTo("dummyToken");
    }
}
