package ua.tqs.airportManager.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SeatTest {

    @Test
    void testNoArgsConstructor() {
        Seat seat = new Seat();
        assertThat(seat).isNotNull();
    }

    @Test
    void testAllArgsConstructor() {
        Flight flight = new Flight();
        Seat seat = new Seat("S123", "12A", "F123", flight);
        assertThat(seat.getSeatId()).isEqualTo("S123");
        assertThat(seat.getSeatNumber()).isEqualTo("12A");
        assertThat(seat.getFlightId()).isEqualTo("F123");
        assertThat(seat.getFlight()).isEqualTo(flight);
    }

    @Test
    void testSettersAndGetters() {
        Flight flight = new Flight();
        Seat seat = new Seat();
        seat.setSeatId("S123");
        seat.setSeatNumber("12A");
        seat.setFlightId("F123");
        seat.setFlight(flight);

        assertThat(seat.getSeatId()).isEqualTo("S123");
        assertThat(seat.getSeatNumber()).isEqualTo("12A");
        assertThat(seat.getFlightId()).isEqualTo("F123");
        assertThat(seat.getFlight()).isEqualTo(flight);
    }

    @Test
    void testToString() {
        Flight flight = new Flight();
        Seat seat = new Seat("S123", "12A", "F123", flight);
        String expectedString = "Seat(seatId=S123, seatNumber=12A, flightId=F123, flight=Flight(...))";
        assertThat(seat.toString()).contains("seatId=S123");
        assertThat(seat.toString()).contains("seatNumber=12A");
        assertThat(seat.toString()).contains("flightId=F123");
    }

}
