package ua.tqs.airportManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.Airline;

public interface AirlineRepository extends JpaRepository<Airline, String> {
    
    Airline findByAirlineCode(String airlineCode);
}
