package ua.tqs.airportManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.*;
import ua.tqs.airportManager.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, String>{
    
    
    Flight findByFlightId(String flightId);
    List<Flight> findByState(String state);
    List<Flight> findByDepartureCityAndArrivalCityAndDate(String departureCity, String arrivalCity, LocalDate flightDate);

    @Query("SELECT DISTINCT f.departureCity FROM Flight f")
    List<String> findAllDepartureCities();

    @Query("SELECT DISTINCT f.arrivalCity FROM Flight f")
    List<String> findAllArrivalCities();
}
