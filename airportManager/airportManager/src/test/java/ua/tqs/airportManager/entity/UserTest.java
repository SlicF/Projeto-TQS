package ua.tqs.airportManager.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.tqs.airportManager.Roles;

public class UserTest {
    
    private static User user;

    @BeforeAll
    public static void setUp() {
        user = new User();
        user.setUserId("1");
        user.setFirstName("João");
        user.setLastName("Neves");
        user.setSex("Masculino");
        user.setBirthDate(LocalDate.of(2004, 2, 11));
        user.setUsername("joaoNeves");
        user.setPassword("password123");
        user.setPhoneNumber("917133984");
        user.setEmail("joaoNeves@gmail.com");
        user.setPassportNumber("A12485");
        user.setNationality("Portuguesa");
        user.setPostalCode("4430-450");
        user.setStreetAddress("Rua Santa Inácio, 148");
        user.setCity("Porto");
        user.setCountry("Portugal");
        user.setRole(Roles.USER);
    }

    @DisplayName("Test User Entity")
    @Test
    void getUserTest() {
        assertAll(
            () -> assertEquals("1", user.getUserId()),
            () -> assertEquals("João", user.getFirstName()),
            () -> assertEquals("Neves", user.getLastName()),
            () -> assertEquals("Masculino", user.getSex()),
            () -> assertEquals(LocalDate.of(2004, 2, 11), user.getBirthDate()),
            () -> assertEquals("joaoNeves", user.getUsername()),
            () -> assertEquals("password123", user.getPassword()),
            () -> assertEquals("917133984", user.getPhoneNumber()),
            () -> assertEquals("joaoNeves@gmail.com", user.getEmail()),
            () -> assertEquals("A12485", user.getPassportNumber()),
            () -> assertEquals("Portuguesa", user.getNationality()),
            () -> assertEquals("4430-450", user.getPostalCode()),
            () -> assertEquals("Rua Santa Inácio, 148", user.getStreetAddress()),
            () -> assertEquals("Porto", user.getCity()),
            () -> assertEquals("Portugal", user.getCountry()),
            () -> assertEquals(Roles.USER, user.getRole())
        );
    }
}