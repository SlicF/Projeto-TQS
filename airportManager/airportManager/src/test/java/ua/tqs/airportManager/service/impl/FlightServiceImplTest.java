package ua.tqs.airportManager.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.repository.FlightRepository;

class FlightServiceImplTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateFlight() {
        Flight flight = new Flight();
        flight.setFlightId("F123");

        when(flightRepository.save(any(Flight.class))).thenReturn(flight);

        Flight createdFlight = flightService.createFlight(flight);

        assertNotNull(createdFlight);
        assertEquals("F123", createdFlight.getFlightId());
        verify(flightRepository, times(1)).save(any(Flight.class));
    }

    @Test
    void testGetFlightsByState() {
        Flight flight1 = new Flight();
        flight1.setFlightId("F123");

        Flight flight2 = new Flight();
        flight2.setFlightId("F124");

        List<Flight> flights = Arrays.asList(flight1, flight2);

        when(flightRepository.findByState("On Time")).thenReturn(flights);

        List<Flight> foundFlights = flightService.getFlightsByState("On Time");

        assertNotNull(foundFlights);
        assertEquals(2, foundFlights.size());
        verify(flightRepository, times(1)).findByState("On Time");
    }

    @Test
    void testGetAllFlights() {
        Flight flight1 = new Flight();
        flight1.setFlightId("F123");

        Flight flight2 = new Flight();
        flight2.setFlightId("F124");

        List<Flight> flights = Arrays.asList(flight1, flight2);

        when(flightRepository.findAll()).thenReturn(flights);

        List<Flight> foundFlights = flightService.getAllFlights();

        assertNotNull(foundFlights);
        assertEquals(2, foundFlights.size());
        verify(flightRepository, times(1)).findAll();
    }

    @Test
    void testFindByDepartureCityAndArrivalCityAndDate() {
        Flight flight = new Flight();
        flight.setFlightId("F123");

        List<Flight> flights = Arrays.asList(flight);
        LocalDate date = LocalDate.of(2023, 6, 3);

        when(flightRepository.findByDepartureCityAndArrivalCityAndDate("CityA", "CityB", date)).thenReturn(flights);

        List<Flight> foundFlights = flightService.findByDepartureCityAndArrivalCityAndDate("CityA", "CityB", date);

        assertNotNull(foundFlights);
        assertEquals(1, foundFlights.size());
        verify(flightRepository, times(1)).findByDepartureCityAndArrivalCityAndDate("CityA", "CityB", date);
    }

}