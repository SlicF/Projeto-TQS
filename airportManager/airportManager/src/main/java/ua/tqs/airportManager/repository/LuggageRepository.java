package ua.tqs.airportManager.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.Luggage;

public interface LuggageRepository extends JpaRepository<Luggage, String> {
    
    Optional<Luggage> findByLuggageId (String lugaggeId);

    List<Luggage> findByReservationId(String reservationId);
}