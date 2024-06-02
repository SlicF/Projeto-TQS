package ua.tqs.airportManager.entity;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
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
    static void setUp() {

        airlines.add(airline1);
        airlines.add(airline2);
        airlines.add(airline3);
        airlines.add(airline4);
    }

    @DisplayName("return a airline")
    @Test
    void getAirlineTest(){
        
        assertAll(
            () -> assertEquals("TAP", airlines.get(0).getAirlineCode()),
            () -> assertEquals("Ryan Air Services", airlines.get(1).getAirlineName()),
            () -> assertEquals("easyJet Europe", airlines.get(2).getAirlineName()),
            () -> assertEquals("QTR", airlines.get(3).getAirlineCode())
        );
    }

}
