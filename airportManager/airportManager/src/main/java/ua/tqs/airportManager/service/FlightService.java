package ua.tqs.airportManager.service;

import java.time.LocalDate;
import java.util.*;
import ua.tqs.airportManager.entity.Flight;

public interface FlightService { // pode ter os mesmos nomes que os metodos do repository?!
    
    Flight createFlight(Flight flight);
    Flight getFlightByFlightId(String flightId);
    List<Flight> getFlightsByState(String state);
    List<Flight> getAllFlights();
    List<Flight> findByDepartureCityArrivalCityDate(String departureCity, String arrivalCity, LocalDate flightDate);
}
