package ua.tqs.airportManager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, String> {
    
    Passenger findByPassengerId (String passengerId);
    List<Passenger> findByState (String state);
    List<Passenger> findByUserId(int userId);
}
