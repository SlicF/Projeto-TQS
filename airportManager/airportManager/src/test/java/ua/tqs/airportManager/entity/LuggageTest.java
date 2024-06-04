package ua.tqs.airportManager.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LuggageTest {

    @Test
    void testNoArgsConstructor() {
        Luggage luggage = new Luggage();
        assertThat(luggage).isNotNull();
    }

    @Test
    void testAllArgsConstructor() {
        Reservation reservation = new Reservation();
        Luggage luggage = new Luggage("L123", "R123", "20", reservation);
        
        assertThat(luggage.getLuggageId()).isEqualTo("L123");
        assertThat(luggage.getReservationId()).isEqualTo("R123");
        assertThat(luggage.getWeight()).isEqualTo("20");
        assertThat(luggage.getReservation()).isEqualTo(reservation);
    }

    @Test
    void testSettersAndGetters() {
        Reservation reservation = new Reservation();
        Luggage luggage = new Luggage();
        luggage.setLuggageId("L123");
        luggage.setReservationId("R123");
        luggage.setWeight("20");
        luggage.setReservation(reservation);
        
        assertThat(luggage.getLuggageId()).isEqualTo("L123");
        assertThat(luggage.getReservationId()).isEqualTo("R123");
        assertThat(luggage.getWeight()).isEqualTo("20");
        assertThat(luggage.getReservation()).isEqualTo(reservation);
    }

    @Test
    void testToString() {
        Reservation reservation = new Reservation();
        Luggage luggage = new Luggage("L123", "R123", "20", reservation);
        
        assertThat(luggage.toString()).contains("luggageId=L123");
        assertThat(luggage.toString()).contains("reservationId=R123");
        assertThat(luggage.toString()).contains("weight=20");
    }

}
