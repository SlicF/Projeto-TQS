package ua.tqs.airportManager.config;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ApplicationConfigTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ApplicationConfig applicationConfig;

    @Test
    void testPasswordEncoder() {
        PasswordEncoder passwordEncoder = applicationConfig.passwordEncoder();
        assertThat(passwordEncoder).isInstanceOf(BCryptPasswordEncoder.class);
    }

    @Test
    void testUserDetailsService() {
        User user = new User("john.doe@example.com", "John", "Doe", "password", "john.doe@example.com", "1234567890", "City", "Country", null);
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(user));

        UserDetailsService userDetailsService = applicationConfig.userDetailService();
        assertThat(userDetailsService.loadUserByUsername("john.doe@example.com")).isEqualTo(user);

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("invalid@example.com");
        });
    }

    @Test
    void testAuthenticationProvider() {
        AuthenticationProvider authenticationProvider = applicationConfig.authenticationProvider();
        assertThat(authenticationProvider).isInstanceOf(DaoAuthenticationProvider.class);
    }

    
}
