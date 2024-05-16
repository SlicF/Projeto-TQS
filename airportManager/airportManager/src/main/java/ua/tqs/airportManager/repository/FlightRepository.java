package ua.tqs.airportManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.*;
import ua.tqs.airportManager.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, String>{
    
    Flight findByFlightId(String flightId);
    List<Flight> findByState(String state);
    List<Flight> findByDepartureCityAndArrivalCityAndDate(String departureCity, String arrivalCity, LocalDate flightDate);
}
