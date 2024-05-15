package ua.tqs.airportManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import ua.tqs.airportManager.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, String>{
    
    Flight findByFlightId(String flightId);
    List<Flight> findByState(String state);
    List<Flight> findByDepartureCityArrivalCityDate(String departureCity, String arrivalCity, Date flightDate);
}
