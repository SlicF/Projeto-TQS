package ua.tqs.airportManager.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AuthResponseTest {

    @Test
    void testNoArgsConstructor() {
        AuthResponse authResponse = new AuthResponse();
        assertThat(authResponse).isNotNull();
    }

    @Test
    void testAllArgsConstructor() {
        AuthResponse authResponse = new AuthResponse("testToken");
        assertThat(authResponse.getToken()).isEqualTo("testToken");
    }

    @Test
    void testBuilder() {
        AuthResponse authResponse = AuthResponse.builder()
                                                .token("builderToken")
                                                .build();
        assertThat(authResponse.getToken()).isEqualTo("builderToken");
    }

    @Test
    void testSetAndGetToken() {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken("newToken");
        assertThat(authResponse.getToken()).isEqualTo("newToken");
    }

    @Test
    void testGetUserId() {
        AuthResponse authResponse = new AuthResponse();
        assertThrows(UnsupportedOperationException.class, authResponse::getUserId);
    }

    @Test
    void testSetUserId() {
        AuthResponse authResponse = new AuthResponse();
        assertThrows(UnsupportedOperationException.class, () -> authResponse.setUserId(1));
    }

    @Test
    void testToString() {
        AuthResponse authResponse = new AuthResponse("testToken");
        String expectedString = "AuthResponse(token=testToken)";
        assertThat(authResponse).hasToString(expectedString);
    }

    @Test
    void testEqualsAndHashCode() {
        AuthResponse authResponse1 = new AuthResponse("testToken");
        AuthResponse authResponse2 = new AuthResponse("testToken");

        assertThat(authResponse1).isEqualTo(authResponse2);
        assertThat(authResponse1.hashCode()).isEqualTo(authResponse2.hashCode());
    }
}
