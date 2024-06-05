package ua.tqs.airportManager.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.repository.FlightRepository;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight();
        flight.setFlightId("F123");
        flight.setDepartureCity("CityA");
        flight.setArrivalCity("CityB");
        flight.setDate(LocalDate.now());
        flight.setState("Scheduled");
    }

    @Test
    void testCreateFlight() {
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);

        Flight createdFlight = flightService.createFlight(flight);

        assertNotNull(createdFlight);
        assertEquals(flight.getFlightId(), createdFlight.getFlightId());
    }


    @Test
    void testGetFlightsByState() {
        Flight flight2 = new Flight();
        flight2.setFlightId("F124");
        flight2.setDepartureCity("CityC");
        flight2.setArrivalCity("CityD");
        flight2.setDate(LocalDate.now());
        flight2.setState("Scheduled");

        when(flightRepository.findByState(anyString())).thenReturn(Arrays.asList(flight, flight2));

        List<Flight> flights = flightService.getFlightsByState("Scheduled");

        assertNotNull(flights);
        assertEquals(2, flights.size());
    }

    @Test
    void testGetAllFlights() {
        Flight flight2 = new Flight();
        flight2.setFlightId("F124");
        flight2.setDepartureCity("CityC");
        flight2.setArrivalCity("CityD");
        flight2.setDate(LocalDate.now());
        flight2.setState("Scheduled");

        when(flightRepository.findAll()).thenReturn(Arrays.asList(flight, flight2));

        List<Flight> allFlights = flightService.getAllFlights();

        assertNotNull(allFlights);
        assertEquals(2, allFlights.size());
    }

    @Test
    void testFindByDepartureCityAndArrivalCityAndDate() {
        when(flightRepository.findByDepartureCityAndArrivalCityAndDate(anyString(), anyString(), any(LocalDate.class)))
            .thenReturn(Arrays.asList(flight));

        List<Flight> flights = flightService.findByDepartureCityAndArrivalCityAndDate("CityA", "CityB", LocalDate.now());

        assertNotNull(flights);
        assertEquals(1, flights.size());
    }

    @Test
    void testGetAllCities() {
        when(flightRepository.findAllArrivalCities()).thenReturn(Arrays.asList("CityA", "CityB", "CityC"));

        List<String> cities = flightService.getAllCities();

        assertNotNull(cities);
        assertEquals(3, cities.size());
    }
}
