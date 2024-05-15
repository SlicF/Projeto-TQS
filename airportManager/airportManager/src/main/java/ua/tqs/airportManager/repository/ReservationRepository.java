package ua.tqs.airportManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    
    Reservation findByReservationId (String reservationId);
    // Reservation findReservationByPassengerId (String passengerId);
}
