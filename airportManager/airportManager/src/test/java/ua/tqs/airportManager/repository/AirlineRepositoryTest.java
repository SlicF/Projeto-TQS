package ua.tqs.airportManager.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ua.tqs.airportManager.entity.Airline;

@DataJpaTest
public class AirlineRepositoryTest {

    @Autowired
    private AirlineRepository airlineRepository;

    @Test
    public void testFindByAirlineCode() {
        // Create a new airline
        Airline airline = new Airline();
        airline.setAirlineCode("ABC");
        airline.setAirlineName("Airline ABC");
        airlineRepository.save(airline);

        // Find the airline by airline code
        Airline foundAirline = airlineRepository.findByAirlineCode("ABC");

        // Assert that the found airline is not null
        assertNotNull(foundAirline);

        // Assert that the found airline has the correct airline code
        assertEquals("ABC", foundAirline.getAirlineCode());
    }
}