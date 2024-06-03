package ua.tqs.airportManager.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthResponseTest {

    @Test
    @DisplayName("Test creating AuthResponse using all-args constructor")
    public void testAllArgsConstructor() {
        AuthResponse authResponse = new AuthResponse("sample_token");
        assertNotNull(authResponse);
        assertEquals("sample_token", authResponse.getToken());
    }

    @Test
    @DisplayName("Test creating AuthResponse using no-args constructor")
    public void testNoArgsConstructor() {
        AuthResponse authResponse = new AuthResponse();
        assertNotNull(authResponse);
        authResponse.setToken("sample_token");
        assertEquals("sample_token", authResponse.getToken());
    }

    @Test
    @DisplayName("Test creating AuthResponse using builder")
    public void testBuilder() {
        AuthResponse authResponse = AuthResponse.builder()
                .token("sample_token")
                .build();
        assertNotNull(authResponse);
        assertEquals("sample_token", authResponse.getToken());
    }

    @Test
    @DisplayName("Test setting and getting token in AuthResponse")
    public void testSetAndGetToken() {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken("sample_token");
        assertEquals("sample_token", authResponse.getToken());
    }
}
