package ua.tqs.airportManager.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class RegisterDTOTest {

    @Test
    void testNoArgsConstructor() {
        RegisterDTO registerDTO = new RegisterDTO();
        assertNotNull(registerDTO);
    }

    @Test
    void testAllArgsConstructor() {
        RegisterDTO registerDTO = new RegisterDTO("testuser", "John", "Doe", "password123", "test@example.com", "A12345678", "City", "Country");
        assertNotNull(registerDTO);
        assertEquals("testuser", registerDTO.getUsername());
        assertEquals("John", registerDTO.getFirstName());
        assertEquals("Doe", registerDTO.getLastName());
        assertEquals("password123", registerDTO.getPassword());
        assertEquals("test@example.com", registerDTO.getEmail());
        assertEquals("A12345678", registerDTO.getPassportNumber());
        assertEquals("City", registerDTO.getCity());
        assertEquals("Country", registerDTO.getCountry());
    }

    @Test
    void testBuilder() {
        RegisterDTO registerDTO = RegisterDTO.builder()
                                             .username("builderuser")
                                             .firstName("Builder")
                                             .lastName("User")
                                             .password("builderPassword")
                                             .email("builder@example.com")
                                             .passportNumber("B87654321")
                                             .city("BuilderCity")
                                             .country("BuilderCountry")
                                             .build();
        assertNotNull(registerDTO);
        assertEquals("builderuser", registerDTO.getUsername());
        assertEquals("Builder", registerDTO.getFirstName());
        assertEquals("User", registerDTO.getLastName());
        assertEquals("builderPassword", registerDTO.getPassword());
        assertEquals("builder@example.com", registerDTO.getEmail());
        assertEquals("B87654321", registerDTO.getPassportNumber());
        assertEquals("BuilderCity", registerDTO.getCity());
        assertEquals("BuilderCountry", registerDTO.getCountry());
    }

    @Test
    void testSetAndGetUsername() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setUsername("newuser");
        assertEquals("newuser", registerDTO.getUsername());
    }

    @Test
    void testSetAndGetFirstName() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setFirstName("NewFirstName");
        assertEquals("NewFirstName", registerDTO.getFirstName());
    }

    @Test
    void testSetAndGetLastName() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setLastName("NewLastName");
        assertEquals("NewLastName", registerDTO.getLastName());
    }

    @Test
    void testSetAndGetPassword() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setPassword("newPassword");
        assertEquals("newPassword", registerDTO.getPassword());
    }

    @Test
    void testSetAndGetEmail() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", registerDTO.getEmail());
    }

    @Test
    void testSetAndGetPassportNumber() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setPassportNumber("N12345678");
        assertEquals("N12345678", registerDTO.getPassportNumber());
    }

    @Test
    void testSetAndGetCity() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setCity("NewCity");
        assertEquals("NewCity", registerDTO.getCity());
    }

    @Test
    void testSetAndGetCountry() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setCountry("NewCountry");
        assertEquals("NewCountry", registerDTO.getCountry());
    }

    @Test
    void testToString() {
        RegisterDTO registerDTO = new RegisterDTO("testuser", "John", "Doe", "password123", "test@example.com", "A12345678", "City", "Country");
        String expectedString = "RegisterDTO(username=testuser, firstName=John, lastName=Doe, password=password123, email=test@example.com, passportNumber=A12345678, city=City, country=Country)";
        assertEquals(expectedString, registerDTO.toString());
    }

    @Test
    void testEquals() {
        RegisterDTO registerDTO1 = new RegisterDTO("testuser", "John", "Doe", "password123", "test@example.com", "A12345678", "City", "Country");
        RegisterDTO registerDTO2 = new RegisterDTO("testuser", "John", "Doe", "password123", "test@example.com", "A12345678", "City", "Country");
        assertEquals(registerDTO1, registerDTO2);
    }

    @Test
    void testHashCode() {
        RegisterDTO registerDTO1 = new RegisterDTO("testuser", "John", "Doe", "password123", "test@example.com", "A12345678", "City", "Country");
        RegisterDTO registerDTO2 = new RegisterDTO("testuser", "John", "Doe", "password123", "test@example.com", "A12345678", "City", "Country");
        assertEquals(registerDTO1.hashCode(), registerDTO2.hashCode());
    }
}
