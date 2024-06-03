package ua.tqs.airportManager.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FlightTest {

    private static List<Flight> flights = new ArrayList<>();

    static LocalDate flightDate13 = LocalDate.of(2024, 5, 19);
    static LocalDate flightDate24 = LocalDate.of(2024, 7, 4);

    static Airline airline1 = new Airline("TAP", "TAP Portugal");
    static Airline airline2 = new Airline("RYA", "Ryan Air Services");
    static Airline airline3 = new Airline("EJU", "easyJet Europe");

    static Flight flight1 = new Flight("PTIT235", "TAP", "Portugal", "Itália", flightDate13, "09h47", "12h53", "150€", "OK", 230, airline1);
    static Flight flight2 = new Flight("PTFR873", "TAP", "Portugal", "França", flightDate24, "06h32", "08h10", "123€", "OK", 230, airline1);
    static Flight flight3 = new Flight("PTMDR014", "RYA", "Portugal", "Madrid", flightDate13, "15h20", "17h43", "187€", "OK", 140, airline2);
    static Flight flight4 = new Flight("PTGRC059", "EJU", "Portugal", "Grécia", flightDate24, "05h25", "08h52", "237€", "Cancelado", 125, airline3);

    @BeforeAll
    public static void setUp() {
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
    }

    @DisplayName("return a flight")
    @Test
    void getFlightTest() {
        assertAll(
            () -> assertEquals("TAP Portugal", flights.get(0).getAirline().getAirlineName()),
            () -> assertEquals(flightDate24, flights.get(1).getDate()),
            () -> assertEquals("Cancelado", flights.get(3).getState()),
            () -> assertEquals("Itália", flights.get(0).getArrivalCity()),
            () -> assertEquals("06h32", flights.get(1).getDepartureHour())
        );
    }

    @Test
    @DisplayName("test association between flight and airline")
    void testReservationFlightAssociation() {
        assertEquals(airline1, flight1.getAirline());
        assertEquals(airline2, flight3.getAirline());
    }

    @Test
    void testAllArgsConstructor() {
        Airline airline = new Airline();
        LocalDate flightDate = LocalDate.of(2024, 6, 3);

        Flight flight = new Flight(
            "F12345", "AC123", "New York", "London", flightDate,
            "10:00", "22:00", "500", "On Time", 180, airline
        );

        assertThat(flight.getFlightId()).isEqualTo("F12345");
        assertThat(flight.getAirlineCode()).isEqualTo("AC123");
        assertThat(flight.getDepartureCity()).isEqualTo("New York");
        assertThat(flight.getArrivalCity()).isEqualTo("London");
        assertThat(flight.getDate()).isEqualTo(flightDate);
        assertThat(flight.getDepartureHour()).isEqualTo("10:00");
        assertThat(flight.getArrivalHour()).isEqualTo("22:00");
        assertThat(flight.getPrice()).isEqualTo("500");
        assertThat(flight.getState()).isEqualTo("On Time");
        assertThat(flight.getSeatsNumber()).isEqualTo(180);
        assertThat(flight.getAirline()).isEqualTo(airline);
    }

    @Test
    void testSettersAndGetters() {
        Airline airline = new Airline();
        LocalDate flightDate = LocalDate.of(2024, 6, 3);

        Flight flight = new Flight();
        flight.setFlightId("F12345");
        flight.setAirlineCode("AC123");
        flight.setDepartureCity("New York");
        flight.setArrivalCity("London");
        flight.setDate(flightDate);
        flight.setDepartureHour("10:00");
        flight.setArrivalHour("22:00");
        flight.setPrice("500");
        flight.setState("On Time");
        flight.setSeatsNumber(180);
        flight.setAirline(airline);

        assertThat(flight.getFlightId()).isEqualTo("F12345");
        assertThat(flight.getAirlineCode()).isEqualTo("AC123");
        assertThat(flight.getDepartureCity()).isEqualTo("New York");
        assertThat(flight.getArrivalCity()).isEqualTo("London");
        assertThat(flight.getDate()).isEqualTo(flightDate);
        assertThat(flight.getDepartureHour()).isEqualTo("10:00");
        assertThat(flight.getArrivalHour()).isEqualTo("22:00");
        assertThat(flight.getPrice()).isEqualTo("500");
        assertThat(flight.getState()).isEqualTo("On Time");
        assertThat(flight.getSeatsNumber()).isEqualTo(180);
        assertThat(flight.getAirline()).isEqualTo(airline);
    }

  
 

    @Test
    void testNoArgsConstructor() {
        Flight flight = new Flight();
        assertThat(flight).isNotNull();
    }
}
