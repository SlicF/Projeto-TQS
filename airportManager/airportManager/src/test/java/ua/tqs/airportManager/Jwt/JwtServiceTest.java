package ua.tqs.airportManager.Jwt;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

class JwtServiceTest {

    @InjectMocks
    private JwtService jwtService;

    @Mock
    private Claims claims;

    private UserDetails userDetails;
    private String token;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userDetails = new User("testUser", "password", new ArrayList<>());
        token = jwtService.getToken(userDetails);
    }

    @Test
    void testGetToken() {
        assertNotNull(token);
        String username = jwtService.getUsernameFromToken(token);
        assertEquals("testUser", username);
    }

    @Test
    void testGetUsernameFromToken() {
        String username = jwtService.getUsernameFromToken(token);
        assertEquals("testUser", username);
    }

    @Test
    void testIsTokenValid() {
        assertTrue(jwtService.isTokenValid(token, userDetails));
    }

    @Test
    void testIsTokenInvalid() {
        UserDetails differentUser = new User("differentUser", "password", new ArrayList<>());
        assertFalse(jwtService.isTokenValid(token, differentUser));
    }

    @Test
    void testGetClaim() {
        when(claims.getSubject()).thenReturn("testUser");
        String subject = jwtService.getClaim(token, Claims::getSubject);
        assertEquals("testUser", subject);
    }

    @Test
    void testIsTokenExpired() {
        assertFalse(jwtService.isTokenExpired(token));
    }
}
