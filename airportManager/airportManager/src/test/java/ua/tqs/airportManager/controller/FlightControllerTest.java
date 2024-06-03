package ua.tqs.airportManager.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ua.tqs.airportManager.entity.Airline;
import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.service.AirlineService;
import ua.tqs.airportManager.service.FlightService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

class FlightControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AirlineService airlineService;

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
    }

    @DisplayName("Test getAirlines")
    @Test
    void testGetAirlines() throws Exception {
        List<Airline> airlines = new ArrayList<>();
        airlines.add(new Airline());
        airlines.add(new Airline());

        when(airlineService.getAllAirlines()).thenReturn(airlines);

        mockMvc.perform(get("/api/flights/airlines"))
                .andExpect(status().isOk());
    }

    @DisplayName("Test getAllCities")
    @Test
    void testGetAllCities() throws Exception {
        List<String> cities = new ArrayList<>();
        cities.add("City1");
        cities.add("City2");

        when(flightService.getAllCities()).thenReturn(cities);

        mockMvc.perform(get("/api/flights/cities"))
                .andExpect(status().isOk());
    }

    @DisplayName("Test getFlights")
    @Test
    void testGetFlights() throws Exception {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight());
        flights.add(new Flight());

        when(flightService.getAllFlights()).thenReturn(flights);

        mockMvc.perform(get("/api/flights/flights"))
                .andExpect(status().isOk());
    }

    @DisplayName("Test getFlightsState")
    @Test
    void testGetFlightsState() throws Exception {
        String state = "State1";
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight());
        flights.add(new Flight());

        when(flightService.getFlightsByState(state)).thenReturn(flights);

        mockMvc.perform(get("/api/flights/flights/" + state))
                .andExpect(status().isOk());
    }

    @DisplayName("Test getFlightCheckout")
    @Test
    void testGetFlightCheckout() throws Exception {
        String flightId = "1";
        Flight flight = new Flight();
        flight.setFlightId(flightId);

        when(flightService.getFlightByFlightId(flightId)).thenReturn(flight);

        mockMvc.perform(get("/api/flights/flightCheckout/" + flightId))
                .andExpect(status().isOk());
    }

    @DisplayName("Test searchFlights")
    @Test
    void testSearchFlights() throws Exception {
        Flight search = new Flight();
        search.setDepartureCity("City1");
        search.setArrivalCity("City2");
        LocalDate date = LocalDate.of(2022, 1, 1);
        search.setDate(date);

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight());
        flights.add(new Flight());

        when(flightService.findByDepartureCityAndArrivalCityAndDate(search.getDepartureCity().trim(),
                search.getArrivalCity().trim(), search.getDate())).thenReturn(flights);

        mockMvc.perform(post("/api/flights/searchFlight")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"departureCity\": \"City1\", \"arrivalCity\": \"City2\", \"date\": \"2022-01-01\"}"))
                .andExpect(status().isOk());
    }
}