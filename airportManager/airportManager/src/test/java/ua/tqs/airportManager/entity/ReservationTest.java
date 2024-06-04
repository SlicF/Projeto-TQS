package ua.tqs.airportManager.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ReservationTest {

    @Test
    void testNoArgsConstructor() {
        Reservation reservation = new Reservation();
        assertThat(reservation).isNotNull();
    }

    @Test
    void testAllArgsConstructor() {
        Passenger passenger = new Passenger();
        Flight flight = new Flight();
        LocalDate reservationDate = LocalDate.of(2023, 1, 1);
        
        Reservation reservation = new Reservation(
            "R12345", "P123", "F123", "12A", 100.0, reservationDate,
            "John Doe", "1234567890123456", "USA", passenger, flight
        );
        
        assertThat(reservation.getReservationId()).isEqualTo("R12345");
        assertThat(reservation.getPassengerId()).isEqualTo("P123");
        assertThat(reservation.getFlightId()).isEqualTo("F123");
        assertThat(reservation.getSeat()).isEqualTo("12A");
        assertThat(reservation.getTotalPrice()).isEqualTo(100.0);
        assertThat(reservation.getReservationDate()).isEqualTo(reservationDate);
        assertThat(reservation.getNameCard()).isEqualTo("John Doe");
        assertThat(reservation.getNumberCard()).isEqualTo("1234567890123456");
        assertThat(reservation.getCountryCard()).isEqualTo("USA");
        assertThat(reservation.getPassenger()).isEqualTo(passenger);
        assertThat(reservation.getFlight()).isEqualTo(flight);
    }

    @Test
    void testSettersAndGetters() {
        Passenger passenger = new Passenger();
        Flight flight = new Flight();
        LocalDate reservationDate = LocalDate.of(2023, 1, 1);

        Reservation reservation = new Reservation();
        reservation.setReservationId("R12345");
        reservation.setPassengerId("P123");
        reservation.setFlightId("F123");
        reservation.setSeat("12A");
        reservation.setTotalPrice(100.0);
        reservation.setReservationDate(reservationDate);
        reservation.setNameCard("John Doe");
        reservation.setNumberCard("1234567890123456");
        reservation.setCountryCard("USA");
        reservation.setPassenger(passenger);
        reservation.setFlight(flight);

        assertThat(reservation.getReservationId()).isEqualTo("R12345");
        assertThat(reservation.getPassengerId()).isEqualTo("P123");
        assertThat(reservation.getFlightId()).isEqualTo("F123");
        assertThat(reservation.getSeat()).isEqualTo("12A");
        assertThat(reservation.getTotalPrice()).isEqualTo(100.0);
        assertThat(reservation.getReservationDate()).isEqualTo(reservationDate);
        assertThat(reservation.getNameCard()).isEqualTo("John Doe");
        assertThat(reservation.getNumberCard()).isEqualTo("1234567890123456");
        assertThat(reservation.getCountryCard()).isEqualTo("USA");
        assertThat(reservation.getPassenger()).isEqualTo(passenger);
        assertThat(reservation.getFlight()).isEqualTo(flight);
    }

    @Test
    void testToString() {
        Passenger passenger = new Passenger();
        Flight flight = new Flight();
        LocalDate reservationDate = LocalDate.of(2023, 1, 1);
        
        Reservation reservation = new Reservation(
            "R12345", "P123", "F123", "12A", 100.0, reservationDate,
            "John Doe", "1234567890123456", "USA", passenger, flight
        );
        
        assertThat(reservation.toString()).contains("reservationId=R12345");
        assertThat(reservation.toString()).contains("passengerId=P123");
        assertThat(reservation.toString()).contains("flightId=F123");
        assertThat(reservation.toString()).contains("seat=12A");
        assertThat(reservation.toString()).contains("totalPrice=100.0");
        assertThat(reservation.toString()).contains("reservationDate=2023-01-01");
        assertThat(reservation.toString()).contains("nameCard=John Doe");
        assertThat(reservation.toString()).contains("numberCard=1234567890123456");
        assertThat(reservation.toString()).contains("countryCard=USA");
    }

    @Test
    void testGenerateReservationId() {
        Reservation reservation = new Reservation();
        reservation.generateReservationId();
        assertThat(reservation.getReservationId()).isNotNull();
        assertThat(reservation.getReservationId()).hasSize(5);
    }
}
