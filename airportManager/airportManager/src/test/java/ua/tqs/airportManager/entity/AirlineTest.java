package ua.tqs.airportManager.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AirlineTest {
    
    private static List<Airline> airlines = new ArrayList<>();

    static Airline airline1 = new Airline("TAP", "TAP Portugal");
    static Airline airline2 = new Airline("RYA", "Ryan Air Services");
    static Airline airline3 = new Airline("EJU", "easyJet Europe");
    static Airline airline4 = new Airline("QTR", "Qatar Airways");

    @BeforeAll
    public static void setUp() {
        airlines.add(airline1);
        airlines.add(airline2);
        airlines.add(airline3);
        airlines.add(airline4);
    }

    @DisplayName("return an airline")
    @Test
    void getAirlineTest() {
        assertAll(
            () -> assertEquals("TAP", airlines.get(0).getAirlineCode()),
            () -> assertEquals("Ryan Air Services", airlines.get(1).getAirlineName()),
            () -> assertEquals("easyJet Europe", airlines.get(2).getAirlineName()),
            () -> assertEquals("QTR", airlines.get(3).getAirlineCode())
        );
    }

    @Test
    void testNoArgsConstructor() {
        Airline airline = new Airline();
        assertThat(airline).isNotNull();
    }

    @Test
    void testAllArgsConstructor() {
        Airline airline = new Airline("AC123", "Airline Name");

        assertThat(airline.getAirlineCode()).isEqualTo("AC123");
        assertThat(airline.getAirlineName()).isEqualTo("Airline Name");
    }

    @Test
    void testSettersAndGetters() {
        Airline airline = new Airline();
        airline.setAirlineCode("AC123");
        airline.setAirlineName("Airline Name");

        assertThat(airline.getAirlineCode()).isEqualTo("AC123");
        assertThat(airline.getAirlineName()).isEqualTo("Airline Name");
    }

    @Test
    void testToString() {
        Airline airline = new Airline("AC123", "Airline Name");

        String expectedString = "Airline(airlineCode=AC123, airlineName=Airline Name)";
        assertThat(airline).hasToString(expectedString);
    }

    @Test
    void testEqualsAndHashCode() {
        Airline airline1 = new Airline("AC123", "Airline Name");
        Airline airline2 = new Airline("AC123", "Airline Name");

        airline2.setAirlineCode("AC124");
        assertThat(airline1).isNotEqualTo(airline2);
        assertThat(airline1.hashCode()).isNotEqualTo(airline2.hashCode());

    }
}
