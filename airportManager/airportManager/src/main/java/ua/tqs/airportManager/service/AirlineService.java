package ua.tqs.airportManager.service;

import java.util.*;
import ua.tqs.airportManager.entity.Airline;

public interface AirlineService {
    
    Airline createAirline(Airline airline);
    Airline getAirlineByAirlineCode(String airlineCode);
    List<Airline> getAllAirlines();
}