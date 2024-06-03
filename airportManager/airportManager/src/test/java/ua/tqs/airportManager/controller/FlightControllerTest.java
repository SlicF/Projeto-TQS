package ua.tqs.airportManager.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ua.tqs.airportManager.entity.Airline;
import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.service.AirlineService;
import ua.tqs.airportManager.service.FlightService;

public class FlightControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AirlineService airlineService;

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    // @DisplayName("Test getAirlines")
    // @Test
    // public void testGetAirlines() throws Exception {
    //     List<Airline> airlines = Arrays.asList(
    //         new Airline("TAP", "TAP Portugal"),
    //         new Airline("RYA", "RyanAir Services")
    //     );

    //     when(airlineService.getAllAirlines()).thenReturn(airlines);

    //     mockMvc.perform(get("/api/flights/airlines"))
    //         .andExpect(status().isOk())
    //         .andExpect(jsonPath("$[0].iataCode").value("TAP"))
    //         .andExpect(jsonPath("$[0].name").value("TAP Portugal"))
    //         .andExpect(jsonPath("$[1].iataCode").value("RYA"))
    //         .andExpect(jsonPath("$[1].name").value("RyanAir Services"));
    // }

    @DisplayName("Test getAllCities")
    @Test
    public void testGetAllCities() throws Exception {
        List<String> cities = Arrays.asList("Lisbon", "Madrid", "Paris");

        when(flightService.getAllCities()).thenReturn(cities);

        mockMvc.perform(get("/api/flights/cities"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0]").value("Lisbon"))
            .andExpect(jsonPath("$[1]").value("Madrid"))
            .andExpect(jsonPath("$[2]").value("Paris"));

    }

    // @DisplayName("Test getFlights")
    // @Test
    // public void testGetFlights() throws Exception {
    //     List<Flight> flights = Arrays.asList(
    //         new Flight("FL123", "TAP", "Lisbon", "Madrid", LocalDate.of(2024, 6, 7), "07:45", "09:15", "100", "OK", 230, new Airline("TAP", "TAP Portugal")),
    //         new Flight("FL124", "RYA", "Madrid", "Paris", LocalDate.of(2024, 6, 8), "09:45", "11:15", "120", "OK", 210, new Airline("RYA", "RyanAir Services"))
    //     );

    //     when(flightService.getAllFlights()).thenReturn(flights);

    //     mockMvc.perform(get("/api/flights/flights"))
    //         .andExpect(status().isOk())
    //         .andExpect(jsonPath("$[0].flightId").value("FL123"))
    //         .andExpect(jsonPath("$[0].airline.iataCode").value("TAP"))
    //         .andExpect(jsonPath("$[0].departureCity").value("Lisbon"))
    //         .andExpect(jsonPath("$[0].arrivalCity").value("Madrid"))
    //         .andExpect(jsonPath("$[1].flightId").value("FL124"))
    //         .andExpect(jsonPath("$[1].airline.iataCode").value("RYA"))
    //         .andExpect(jsonPath("$[1].departureCity").value("Madrid"))
    //         .andExpect(jsonPath("$[1].arrivalCity").value("Paris"));
    // }

    @DisplayName("Test getFlightsState")
    @Test
    public void testGetFlightsState() throws Exception {
        List<Flight> flights = Arrays.asList(
            new Flight("FL125", "TAP", "Lisbon", "Madrid", LocalDate.of(2024, 6, 7), "07:45", "09:15", "100", "OK", 230, new Airline("TAP", "TAP Portugal"))
        );

        when(flightService.getFlightsByState("OK")).thenReturn(flights);

        mockMvc.perform(get("/api/flights/flights/OK"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].flightId").value("FL125"))
            .andExpect(jsonPath("$[0].state").value("OK"));
    }

    @DisplayName("Test getFlightCheckout")
    @Test
    public void testGetFlightCheckout() throws Exception {
        Flight flight = new Flight("FL126", "TAP", "Lisbon", "Madrid", LocalDate.of(2024, 6, 7), "07:45", "09:15", "100", "OK", 230, new Airline("TAP", "TAP Portugal"));

        when(flightService.getFlightByFlightId("FL126")).thenReturn(flight);

        mockMvc.perform(get("/api/flights/flightCheckout/FL126"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.flightId").value("FL126"))
            .andExpect(jsonPath("$.departureCity").value("Lisbon"))
            .andExpect(jsonPath("$.arrivalCity").value("Madrid"));
    }

    @DisplayName("Test searchFlights")
    @Test
    public void testSearchFlights() throws Exception {
        Flight searchFlight = new Flight();
        searchFlight.setDepartureCity("Lisbon");
        searchFlight.setArrivalCity("Madrid");
        searchFlight.setDate(LocalDate.of(2024, 6, 7));

        List<Flight> flights = Arrays.asList(
            new Flight("FL127", "TAP", "Lisbon", "Madrid", LocalDate.of(2024, 6, 7), "07:45", "09:15", "100", "OK", 230, new Airline("TAP", "TAP Portugal"))
        );

        when(flightService.findByDepartureCityAndArrivalCityAndDate("Lisbon", "Madrid", LocalDate.of(2024, 6, 7))).thenReturn(flights);

        mockMvc.perform(post("/api/flights/searchFlight")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(searchFlight)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].flightId").value("FL127"))
            .andExpect(jsonPath("$[0].departureCity").value("Lisbon"))
            .andExpect(jsonPath("$[0].arrivalCity").value("Madrid"));
    }
}
