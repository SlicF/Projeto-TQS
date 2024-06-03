package ua.tqs.airportManager.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PassengerTest {

    @Test
    void testNoArgsConstructor() {
        Passenger passenger = new Passenger();
        assertThat(passenger).isNotNull();
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate birthDate = LocalDate.of(1990, 1, 1);

        Passenger passenger = new Passenger(
            "P1234567", 1, "John", "Doe", "Checked-in", "Male", birthDate, 
            "john.doe@example.com", "123456789", "A1234567", "12345", 
            "123 Main St", "New York", "USA", "4111111111111111", "1234"
        );
        
        assertThat(passenger.getPassengerId()).isEqualTo("P1234567");
        assertThat(passenger.getUserId()).isEqualTo(1);
        assertThat(passenger.getFirstName()).isEqualTo("John");
        assertThat(passenger.getLastName()).isEqualTo("Doe");
        assertThat(passenger.getState()).isEqualTo("Checked-in");
        assertThat(passenger.getSex()).isEqualTo("Male");
        assertThat(passenger.getBirthDate()).isEqualTo(birthDate);
        assertThat(passenger.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(passenger.getPhoneNumber()).isEqualTo("123456789");
        assertThat(passenger.getPassportNumber()).isEqualTo("A1234567");
        assertThat(passenger.getPostalCode()).isEqualTo("12345");
        assertThat(passenger.getStreetAddress()).isEqualTo("123 Main St");
        assertThat(passenger.getCity()).isEqualTo("New York");
        assertThat(passenger.getCountry()).isEqualTo("USA");
        assertThat(passenger.getCardNumber()).isEqualTo("4111111111111111");
        assertThat(passenger.getCardPIN()).isEqualTo("1234");
    }

    @Test
    void testSettersAndGetters() {
        LocalDate birthDate = LocalDate.of(1990, 1, 1);

        Passenger passenger = new Passenger();
        passenger.setPassengerId("P1234567");
        passenger.setUserId(1);
        passenger.setFirstName("John");
        passenger.setLastName("Doe");
        passenger.setState("Checked-in");
        passenger.setSex("Male");
        passenger.setBirthDate(birthDate);
        passenger.setEmail("john.doe@example.com");
        passenger.setPhoneNumber("123456789");
        passenger.setPassportNumber("A1234567");
        passenger.setPostalCode("12345");
        passenger.setStreetAddress("123 Main St");
        passenger.setCity("New York");
        passenger.setCountry("USA");
        passenger.setCardNumber("4111111111111111");
        passenger.setCardPIN("1234");

        assertThat(passenger.getPassengerId()).isEqualTo("P1234567");
        assertThat(passenger.getUserId()).isEqualTo(1);
        assertThat(passenger.getFirstName()).isEqualTo("John");
        assertThat(passenger.getLastName()).isEqualTo("Doe");
        assertThat(passenger.getState()).isEqualTo("Checked-in");
        assertThat(passenger.getSex()).isEqualTo("Male");
        assertThat(passenger.getBirthDate()).isEqualTo(birthDate);
        assertThat(passenger.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(passenger.getPhoneNumber()).isEqualTo("123456789");
        assertThat(passenger.getPassportNumber()).isEqualTo("A1234567");
        assertThat(passenger.getPostalCode()).isEqualTo("12345");
        assertThat(passenger.getStreetAddress()).isEqualTo("123 Main St");
        assertThat(passenger.getCity()).isEqualTo("New York");
        assertThat(passenger.getCountry()).isEqualTo("USA");
        assertThat(passenger.getCardNumber()).isEqualTo("4111111111111111");
        assertThat(passenger.getCardPIN()).isEqualTo("1234");
    }


    @Test
    void testGeneratePassengerId() {
        Passenger passenger = new Passenger();
        passenger.generateReservationId();
        assertThat(passenger.getPassengerId()).isNotNull();
        assertThat(passenger.getPassengerId()).hasSize(7);
    }
}
