package ua.tqs.airportManager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.Luggage;
import ua.tqs.airportManager.entity.Passenger;

public interface LuggageRepository extends JpaRepository<Luggage, String> {
    
    Optional<Luggage> findByLuggageId (String lugaggeId);
    // List<Luggage> getAllLuggages();

    List<Luggage> findByReservationId(String reservationId);
}