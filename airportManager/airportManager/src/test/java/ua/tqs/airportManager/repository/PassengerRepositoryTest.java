package ua.tqs.airportManager.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ua.tqs.airportManager.entity.Passenger;

@DataJpaTest
class PassengerRepositoryTest {

    @Autowired
    private PassengerRepository passengerRepository;

    @DisplayName("Test findByPassengerId")
    @Test
    void testFindByPassengerId() {
        // Create a passenger
        Passenger passenger = new Passenger();
        passenger.setPassengerId("1");
        passenger.setFirstName("John");
        passenger.setLastName("Doe");
        passenger.setBirthDate(LocalDate.parse("1990-01-01"));
        passenger.setCardNumber("1234567890123456");
        passenger.setCountry("Portugal");
        passenger.setState("Porto");
        passenger.setStreetAddress("Rua de Camões");
        passenger.setCardPIN("1234");
        passenger.setPhoneNumber("912345678");
        passenger.setEmail("email@email.com");
        passenger.setSex("M");
        passenger.setCity("Porto");
        passenger.setPassportNumber("123456789");
        passenger.setPostalCode("4000-000");

        passengerRepository.save(passenger);

        // Find the passenger by passengerId
        Passenger foundPassenger = passengerRepository.findByPassengerId("1");

        // Assert that the found passenger is not null
        assertNotNull(foundPassenger);
        // Assert that the found passenger has the correct passengerId
        assertEquals("1", foundPassenger.getPassengerId());
    }

    @DisplayName("Test findByState")
    @Test
    void testFindByState() {
        // Create passengers with different states
        Passenger passenger1 = new Passenger();
        passenger1.setPassengerId("1");
        passenger1.setFirstName("John");
        passenger1.setLastName("Doe");
        passenger1.setBirthDate(LocalDate.parse("1990-01-01"));
        passenger1.setCardNumber("1234567890123456");
        passenger1.setCountry("Portugal");
        passenger1.setState("Porto");
        passenger1.setStreetAddress("Rua de Camões");
        passenger1.setCardPIN("1234");
        passenger1.setPhoneNumber("912345678");
        passenger1.setEmail("");
        passenger1.setSex("M");
        passenger1.setCity("Porto");
        passenger1.setPassportNumber("123456789");
        passenger1.setPostalCode("4000-000");

        Passenger passenger2 = new Passenger();
        passenger2.setPassengerId("2");
        passenger2.setFirstName("Jane");
        passenger2.setLastName("Doe");
        passenger2.setBirthDate(LocalDate.parse("1990-01-01"));
        passenger2.setCardNumber("1234567890123456");
        passenger2.setCountry("Portugal");
        passenger2.setState("Lisbon");
        passenger2.setStreetAddress("Rua de Camões");
        passenger2.setCardPIN("1234");
        passenger2.setPhoneNumber("912345678");
        passenger2.setEmail("");
        passenger2.setSex("F");
        passenger2.setCity("Lisbon");
        passenger2.setPassportNumber("123456789");
        passenger2.setPostalCode("4000-000");

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);

        // Find passengers by state
        List<Passenger> foundPassengers = passengerRepository.findByState("Porto");

        // Assert that the found passengers list has the correct size
        assertEquals(1, foundPassengers.size());
        // Assert that the found passenger has the correct state
        assertEquals("Porto", foundPassengers.get(0).getState());

        // Find passengers by state
        foundPassengers = passengerRepository.findByState("Lisbon");

        // Assert that the found passengers list has the correct size
        assertEquals(1, foundPassengers.size());
        // Assert that the found passenger has the correct state
        assertEquals("Lisbon", foundPassengers.get(0).getState());
    }
}