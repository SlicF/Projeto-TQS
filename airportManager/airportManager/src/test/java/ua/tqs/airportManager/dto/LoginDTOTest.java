package ua.tqs.airportManager.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LoginDTOTest {

    @Test
    void testNoArgsConstructor() {
        LoginDTO loginDTO = new LoginDTO();
        assertNotNull(loginDTO);
    }

    @Test
    void testAllArgsConstructor() {
        LoginDTO loginDTO = new LoginDTO("test@example.com", "password123");
        assertNotNull(loginDTO);
        assertEquals("test@example.com", loginDTO.getEmail());
        assertEquals("password123", loginDTO.getPassword());
    }

    @Test
    void testBuilder() {
        LoginDTO loginDTO = LoginDTO.builder()
                                    .email("builder@example.com")
                                    .password("builderPassword")
                                    .build();
        assertNotNull(loginDTO);
        assertEquals("builder@example.com", loginDTO.getEmail());
        assertEquals("builderPassword", loginDTO.getPassword());
    }

    @Test
    void testSetAndGetEmail() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", loginDTO.getEmail());
    }

    @Test
    void testSetAndGetPassword() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword("newPassword");
        assertEquals("newPassword", loginDTO.getPassword());
    }

    @Test
    void testToString() {
        LoginDTO loginDTO = new LoginDTO("test@example.com", "password123");
        String expectedString = "LoginDTO(email=test@example.com, password=password123)";
        assertEquals(expectedString, loginDTO.toString());
    }

    @Test
    void testEquals() {
        LoginDTO loginDTO1 = new LoginDTO("test@example.com", "password123");
        LoginDTO loginDTO2 = new LoginDTO("test@example.com", "password123");
        assertEquals(loginDTO1, loginDTO2);
    }

    @Test
    void testHashCode() {
        LoginDTO loginDTO1 = new LoginDTO("test@example.com", "password123");
        LoginDTO loginDTO2 = new LoginDTO("test@example.com", "password123");
        assertEquals(loginDTO1.hashCode(), loginDTO2.hashCode());
    }
}
