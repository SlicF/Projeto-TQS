package ua.tqs.airportManager.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegisterDTOTest {

    @Test
    @DisplayName("Test creating RegisterDTO using all-args constructor")
    public void testAllArgsConstructor() {
        RegisterDTO registerDTO = new RegisterDTO("John", "Doe", "john.doe@example.com", "password123", "A12345678", "New York", "USA");
        assertNotNull(registerDTO);
        assertEquals("John", registerDTO.getFirstName());
        assertEquals("Doe", registerDTO.getLastName());
        assertEquals("john.doe@example.com", registerDTO.getEmail());
        assertEquals("password123", registerDTO.getUserPassword());
        assertEquals("A12345678", registerDTO.getPassportNumber());
        assertEquals("New York", registerDTO.getCity());
        assertEquals("USA", registerDTO.getCountry());
    }

    @Test
    @DisplayName("Test creating RegisterDTO using no-args constructor")
    public void testNoArgsConstructor() {
        RegisterDTO registerDTO = new RegisterDTO();
        assertNotNull(registerDTO);
    }

    @Test
    @DisplayName("Test creating RegisterDTO using builder")
    public void testBuilder() {
        RegisterDTO registerDTO = RegisterDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .userPassword("password123")
                .passportNumber("A12345678")
                .city("New York")
                .country("USA")
                .build();
        assertNotNull(registerDTO);
        assertEquals("John", registerDTO.getFirstName());
        assertEquals("Doe", registerDTO.getLastName());
        assertEquals("john.doe@example.com", registerDTO.getEmail());
        assertEquals("password123", registerDTO.getUserPassword());
        assertEquals("A12345678", registerDTO.getPassportNumber());
        assertEquals("New York", registerDTO.getCity());
        assertEquals("USA", registerDTO.getCountry());
    }

    @Test
    @DisplayName("Test setting and getting fields in RegisterDTO")
    public void testSetAndGet() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setFirstName("John");
        registerDTO.setLastName("Doe");
        registerDTO.setEmail("john.doe@example.com");
        registerDTO.setUserPassword("password123");
        registerDTO.setPassportNumber("A12345678");
        registerDTO.setCity("New York");
        registerDTO.setCountry("USA");

        assertEquals("John", registerDTO.getFirstName());
        assertEquals("Doe", registerDTO.getLastName());
        assertEquals("john.doe@example.com", registerDTO.getEmail());
        assertEquals("password123", registerDTO.getUserPassword());
        assertEquals("A12345678", registerDTO.getPassportNumber());
        assertEquals("New York", registerDTO.getCity());
        assertEquals("USA", registerDTO.getCountry());
    }
}
