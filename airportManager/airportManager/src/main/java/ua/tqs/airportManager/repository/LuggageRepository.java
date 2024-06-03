package ua.tqs.airportManager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.Luggage;
import ua.tqs.airportManager.entity.Passenger;

public interface LuggageRepository extends JpaRepository<Luggage, String> {
    
    Luggage findByLuggageId (String lugaggeId);
    // List<Luggage> getAllLuggages();
}