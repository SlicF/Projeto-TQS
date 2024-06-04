package ua.tqs.airportManager.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.tqs.airportManager.entity.Airline;

class AirlineServiceTest {

    @Mock
    private AirlineService airlineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAirline() {
        Airline airline = new Airline();
        airline.setAirlineCode("AA");
        airline.setAirlineName("American Airlines");

        when(airlineService.createAirline(any(Airline.class))).thenReturn(airline);

        Airline createdAirline = airlineService.createAirline(airline);

        assertNotNull(createdAirline);
        assertEquals("AA", createdAirline.getAirlineCode());
        assertEquals("American Airlines", createdAirline.getAirlineName());

        verify(airlineService, times(1)).createAirline(airline);
    }

    @Test
    void testGetAirlineByAirlineCode() {
        Airline airline = new Airline();
        airline.setAirlineCode("AA");
        airline.setAirlineName("American Airlines");

        when(airlineService.getAirlineByAirlineCode("AA")).thenReturn(airline);

        Airline foundAirline = airlineService.getAirlineByAirlineCode("AA");

        assertNotNull(foundAirline);
        assertEquals("AA", foundAirline.getAirlineCode());
        assertEquals("American Airlines", foundAirline.getAirlineName());

        verify(airlineService, times(1)).getAirlineByAirlineCode("AA");
    }

    @Test
    void testGetAllAirlines() {
        Airline airline1 = new Airline();
        airline1.setAirlineCode("AA");
        airline1.setAirlineName("American Airlines");

        Airline airline2 = new Airline();
        airline2.setAirlineCode("DL");
        airline2.setAirlineName("Delta Airlines");

        List<Airline> airlines = Arrays.asList(airline1, airline2);

        when(airlineService.getAllAirlines()).thenReturn(airlines);

        List<Airline> foundAirlines = airlineService.getAllAirlines();

        assertNotNull(foundAirlines);
        assertEquals(2, foundAirlines.size());
        assertTrue(foundAirlines.contains(airline1));
        assertTrue(foundAirlines.contains(airline2));

        verify(airlineService, times(1)).getAllAirlines();
    }
}