package ua.tqs.airportManager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Airline;
import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.service.AirlineService;
import ua.tqs.airportManager.service.FlightService;

import java.util.List;

@CrossOrigin(origins = "http://192.168.160.219:8981", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/flights")
public class FlightController {

    private final AirlineService airlineService;
    private final FlightService flightService;

    @GetMapping("/airlines")
    public ResponseEntity<List<Airline>> getAirlines() {
        List<Airline> airlines = airlineService.getAllAirlines();
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    @GetMapping("/cities")
    public ResponseEntity<List<String>> getAllCities() {
        List<String> cities = flightService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("flights/{state}")
    public ResponseEntity<List<Flight>> getFlightsState(@PathVariable("state") String state) {
        List<Flight> flight = flightService.getFlightsByState(state);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @GetMapping("/flightCheckout/{flightId}")
    public ResponseEntity<Flight> getFlightCheckout(@PathVariable("flightId") String flightId) {
        Flight flight = flightService.getFlightByFlightId(flightId);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping(path = "/searchFlight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> searchFlights(@RequestBody Flight search) {
        List<Flight> flights = flightService.findByDepartureCityAndArrivalCityAndDate(
                search.getDepartureCity().trim(),
                search.getArrivalCity().trim(),
                search.getDate());
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @PatchMapping("/{flightId}/{state}")
    public ResponseEntity<Flight> updateFlightState(@PathVariable("flightId") String flightId,
            @PathVariable("state") String state) {
        Flight flight = flightService.getFlightByFlightId(flightId);
        if (flight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        flight.setState(state);
        flightService.updateFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
}