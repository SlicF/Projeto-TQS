package ua.tqs.airportManager.entity;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FlightTest {
    
    private static List<Flight> flights = new ArrayList<>();

    static LocalDate flightDate13 = LocalDate.of(2024, 5, 19);
    static LocalDate flightDate24 = LocalDate.of(2024, 7, 4);

    static ArrayList<String> seatsTaken124 = new ArrayList<>();
    static ArrayList<String> seatsTaken3 = new ArrayList<>(Arrays.asList("AA3", "AB4", "AC7"));

    static Airline airline1 = new Airline("TAP", "TAP Portugal");
    static Airline airline2 = new Airline("RYA", "Ryan Air Services");
    static Airline airline3 = new Airline("EJU", "easyJet Europe");

    static Flight flight1 = new Flight("PTIT235", "TAP", "Portugal", "Itália", flightDate13, "09h47", "12h53", "150€", "OK", 230, seatsTaken124, airline1);
    static Flight flight2 = new Flight("PTFR873", "TAP", "Portugal", "França", flightDate24, "06h32", "08h10", "123€", "OK", 230, seatsTaken124, airline1);
    static Flight flight3 = new Flight("PTMDR014", "RYA", "Portugal", "Madrid", flightDate13, "15h20", "17h43", "187€", "OK", 140, seatsTaken3, airline2);
    static Flight flight4 = new Flight("PTGRC059", "EJU", "Portugal", "Grécia", flightDate24, "05h25", "08h52", "237€", "Cancelado", 125, seatsTaken124, airline3);

    @BeforeAll
    public static void setUp() {

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
    }

    @DisplayName("return a flight")
    @Test
    void getFlightTest(){
        
        assertAll(
            () -> assertEquals("TAP Portugal", flights.get(0).getAirline().getAirlineName()),
            () -> assertEquals(flightDate24, flights.get(1).getDate()),
            () -> assertEquals(seatsTaken3, flights.get(2).getSeatsTaken()),
            () -> assertEquals("Cancelado", flights.get(3).getState()),
            () -> assertEquals("Itália", flights.get(0).getArrivalCity()),
            () -> assertEquals("06h32", flights.get(1).getDepartureHour())
        );
    }

    @Test
    @DisplayName("test association between flight and airline")
    public void testReservationFlightAssociation() {
        assertEquals(airline1, flight1.getAirline());
        assertEquals(airline2, flight3.getAirline());
    }

}