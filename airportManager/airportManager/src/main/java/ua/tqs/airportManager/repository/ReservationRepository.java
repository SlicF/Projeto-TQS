package ua.tqs.airportManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    
    Reservation findByReservationId (String reservationId);
    List<Reservation> findByPassengerId (String passengerId);
}
