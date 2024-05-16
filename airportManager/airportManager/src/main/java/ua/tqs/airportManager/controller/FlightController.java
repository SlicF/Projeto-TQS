// package ua.tqs.airportManager.controller;

// import ua.tqs.airportManager.entity.Flight;
// import ua.tqs.airportManager.service.FlightService;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/flights")
// public class FlightController {

//     private FlightService flightService;

//     @GetMapping("/flights")
//     public ResponseEntity<List<Flight>> getFlights() {
//         List<Flight> flights = flightService.getAllFlights();
//         return new ResponseEntity<>(flights, HttpStatus.OK);
//     }

//     @GetMapping("/flightCheckout/{flightId}")
//     public ResponseEntity<Flight> getFlightCheckout(@PathVariable("flightId") String flightId) {
//         Flight flight = flightService.getFlightByFlightId(flightId);
//         return new ResponseEntity<>(flight, HttpStatus.OK);
//     }

//     @GetMapping("/searchFlight")
//     public ResponseEntity<Map<String, Object>> searchFlights(
//             @RequestParam("airportCodeOrigin") String airportCodeOrigin,
//             @RequestParam("airportCodeArrival") String airportCodeArrival,
//             @RequestParam("departureDate") String departureDateStr,
//             @RequestParam(value = "returnDate", required = false) String returnDateStr) {
        
//         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//         Date departureDate = null;
//         Date returnDate = null;

//         try {
//             departureDate = dateFormat.parse(departureDateStr);
//             if (returnDateStr != null && !returnDateStr.isEmpty()) {
//                 returnDate = dateFormat.parse(returnDateStr);
//             }
//         } catch (ParseException e) {
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", "Invalid date format"));
//         }

//         List<Flight> outboundFlights = flightService.findByDepartureCityArrivalCityDate(airportCodeOrigin, airportCodeArrival, departureDate);
//         List<Flight> returnFlights = new ArrayList<>();

//         if (returnDate != null) {
//             returnFlights = flightService.findByDepartureCityArrivalCityDate(airportCodeArrival, airportCodeOrigin, returnDate);
//         }

//         Map<String, Object> response = new HashMap<>();
//         response.put("outboundFlights", outboundFlights);

//         if (returnDate != null) {
//             response.put("returnFlights", returnFlights);
//         }

//         return new ResponseEntity<>(response, HttpStatus.OK);
//     }
// }

package ua.tqs.airportManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Airline;
import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.service.AirlineService;
import ua.tqs.airportManager.service.FlightService;

@CrossOrigin(origins = "http://localhost:8980")
@RestController
@AllArgsConstructor
@RequestMapping("/api/flights")
public class FlightController {

    private AirlineService airlineService;
    
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/airlines")
    public ResponseEntity<List<Airline>> getAirlines() {
        List<Airline> airlines = airlineService.getAllAirlines();
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{state}") // nao sei como diferenciar, supostamento e com o parametro state
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
            search.getDepartureCity(), search.getArrivalCity(), search.getDate());

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}