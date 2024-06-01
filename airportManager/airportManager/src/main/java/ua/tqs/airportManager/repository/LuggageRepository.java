package ua.tqs.airportManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.Luggage;

public interface LuggageRepository extends JpaRepository<Luggage, String> {
    
    Luggage findByLuggageId (String lugaggeId);
    // List<Luggage> getAllLuggages();
}