package ua.tqs.airportManager.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginDTOTest {

    @Test
    @DisplayName("Test creating LoginDTO using all-args constructor")
    public void testAllArgsConstructor() {
        LoginDTO loginDTO = new LoginDTO("user@example.com", "password123");
        assertNotNull(loginDTO);
        assertEquals("user@example.com", loginDTO.getEmail());
        assertEquals("password123", loginDTO.getPassword());
    }

    @Test
    @DisplayName("Test creating LoginDTO using no-args constructor")
    public void testNoArgsConstructor() {
        LoginDTO loginDTO = new LoginDTO();
        assertNotNull(loginDTO);
        loginDTO.setEmail("user@example.com");
        loginDTO.setPassword("password123");
        assertEquals("user@example.com", loginDTO.getEmail());
        assertEquals("password123", loginDTO.getPassword());
    }

    @Test
    @DisplayName("Test creating LoginDTO using builder")
    public void testBuilder() {
        LoginDTO loginDTO = LoginDTO.builder()
                .email("user@example.com")
                .password("password123")
                .build();
        assertNotNull(loginDTO);
        assertEquals("user@example.com", loginDTO.getEmail());
        assertEquals("password123", loginDTO.getPassword());
    }

    @Test
    @DisplayName("Test setting and getting email and password in LoginDTO")
    public void testSetAndGet() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("user@example.com");
        loginDTO.setPassword("password123");
        assertEquals("user@example.com", loginDTO.getEmail());
        assertEquals("password123", loginDTO.getPassword());
    }
}

