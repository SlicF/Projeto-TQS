package ua.tqs.airportManager.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.repository.FlightRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);
        Flight createdFlight = flightService.createFlight(flight);
        assertEquals(flight, createdFlight);
        verify(flightRepository, times(1)).save(flight);
    }

    @Test
    void testGetFlightByFlightId() {
        Flight flight = new Flight();
        when(flightRepository.findByFlightId(anyString())).thenReturn(flight);
        Flight fetchedFlight = flightService.getFlightByFlightId("ABC123");
        assertEquals(flight, fetchedFlight);
        verify(flightRepository, times(1)).findByFlightId("ABC123");
    }

    @Test
    void testGetFlightsByState() {
        List<Flight> flights = Arrays.asList(new Flight(), new Flight());
        when(flightRepository.findByState(anyString())).thenReturn(flights);
        List<Flight> fetchedFlights = flightService.getFlightsByState("Scheduled");
        assertEquals(flights, fetchedFlights);
        verify(flightRepository, times(1)).findByState("Scheduled");
    }

    @Test
    void testGetAllFlights() {
        List<Flight> flights = Arrays.asList(new Flight(), new Flight());
        when(flightRepository.findAll()).thenReturn(flights);
        List<Flight> fetchedFlights = flightService.getAllFlights();
        assertEquals(flights, fetchedFlights);
        verify(flightRepository, times(1)).findAll();
    }

    @Test
    void testFindByDepartureCityAndArrivalCityAndDate() {
        List<Flight> flights = Arrays.asList(new Flight(), new Flight());
        when(flightRepository.findByDepartureCityAndArrivalCityAndDate(anyString(), anyString(), any(LocalDate.class))).thenReturn(flights);
        List<Flight> fetchedFlights = flightService.findByDepartureCityAndArrivalCityAndDate("CityA", "CityB", LocalDate.now());
        assertEquals(flights, fetchedFlights);
        verify(flightRepository, times(1)).findByDepartureCityAndArrivalCityAndDate("CityA", "CityB", LocalDate.now());
    }

    @Test
    void testGetAllCities() {
        List<String> departureCities = Arrays.asList("CityA", "CityB");
        List<String> arrivalCities = Arrays.asList("CityB", "CityC");
        when(flightRepository.findAllDepartureCities()).thenReturn(departureCities);
        when(flightRepository.findAllArrivalCities()).thenReturn(arrivalCities);
        List<String> allCities = flightService.getAllCities();
        List<String> expectedCities = Arrays.asList("CityA", "CityB", "CityC");
        assertEquals(expectedCities.size(), allCities.size());
        assertTrue(allCities.containsAll(expectedCities));
        verify(flightRepository, times(1)).findAllDepartureCities();
        verify(flightRepository, times(1)).findAllArrivalCities();
    }
}
