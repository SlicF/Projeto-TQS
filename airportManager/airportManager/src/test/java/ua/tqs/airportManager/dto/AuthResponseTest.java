package ua.tqs.airportManager.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class AuthResponseTest {

    @Test
    void testNoArgsConstructor() {
        AuthResponse authResponse = new AuthResponse();
        assertNotNull(authResponse);
    }

    @Test
    void testAllArgsConstructor() {
        AuthResponse authResponse = new AuthResponse("testToken");
        assertNotNull(authResponse);
        assertEquals("testToken", authResponse.getToken());
    }

    @Test
    void testBuilder() {
        AuthResponse authResponse = AuthResponse.builder()
                                                .token("builderToken")
                                                .build();
        assertNotNull(authResponse);
        assertEquals("builderToken", authResponse.getToken());
    }

    @Test
    void testSetAndGetToken() {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken("newToken");
        assertEquals("newToken", authResponse.getToken());
    }

    @Test
    void testToString() {
        AuthResponse authResponse = new AuthResponse("testToken");
        String expectedString = "AuthResponse(token=testToken)";
        assertEquals(expectedString, authResponse.toString());
    }

    @Test
    void testSetUserId() {
        AuthResponse authResponse = new AuthResponse();
        assertThrows(UnsupportedOperationException.class, () -> authResponse.setUserId(1));
    }

    

  
}
