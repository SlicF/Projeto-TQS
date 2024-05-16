package ua.tqs.airportManager.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.tqs.airportManager.Roles;

public class PassengerTest {
    
    private static Passenger passenger;

    @BeforeAll
    public static void setUp() {
        passenger = new Passenger();
        passenger.setUserId(1);
        passenger.setFirstName("João");
        passenger.setLastName("Neves");
        passenger.setSex("Masculino");
        passenger.setBirthDate(LocalDate.of(2004, 2, 11));
        passenger.setUsername("joaoNeves");
        passenger.setPassword("password123");
        passenger.setPhoneNumber("917133984");
        passenger.setEmail("joaoNeves@gmail.com");
        passenger.setPassportNumber("A12485");
        passenger.setNationality("Portuguesa");
        passenger.setPostalCode("4430-450");
        passenger.setStreetAddress("Rua Santa Inácio, 148");
        passenger.setCity("Porto");
        passenger.setCountry("Portugal");
        passenger.setRole(Roles.USER);
    }

    @DisplayName("Test Passenger Entity")
    @Test
    void getPassengerTest() {
        assertAll(
            () -> assertEquals(1, passenger.getUserId()),
            () -> assertEquals("João", passenger.getFirstName()),
            () -> assertEquals("Neves", passenger.getLastName()),
            () -> assertEquals("Masculino", passenger.getSex()),
            () -> assertEquals(LocalDate.of(2004, 2, 11), passenger.getBirthDate()),
            () -> assertEquals("joaoNeves", passenger.getUsername()),
            () -> assertEquals("password123", passenger.getPassword()),
            () -> assertEquals("917133984", passenger.getPhoneNumber()),
            () -> assertEquals("joaoNeves@gmail.com", passenger.getEmail()),
            () -> assertEquals("A12485", passenger.getPassportNumber()),
            () -> assertEquals("Portuguesa", passenger.getNationality()),
            () -> assertEquals("4430-450", passenger.getPostalCode()),
            () -> assertEquals("Rua Santa Inácio, 148", passenger.getStreetAddress()),
            () -> assertEquals("Porto", passenger.getCity()),
            () -> assertEquals("Portugal", passenger.getCountry()),
            () -> assertEquals(Roles.USER, passenger.getRole())
        );
    }
}
