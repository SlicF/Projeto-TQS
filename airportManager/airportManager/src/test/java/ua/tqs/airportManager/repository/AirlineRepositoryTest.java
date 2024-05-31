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
    void testSaveAndFindByAirlineCode() {
        // Given
        Airline airline = new Airline("TAP", "TAP Portugal");

        // When
        airlineRepository.save(airline);
        Airline foundAirline = airlineRepository.findByAirlineCode("TAP");

        // Then
        assertNotNull(foundAirline);
        assertEquals("TAP", foundAirline.getAirlineCode());
    }
}