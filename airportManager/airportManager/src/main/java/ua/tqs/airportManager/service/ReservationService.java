package ua.tqs.airportManager.service;

import java.util.List;
import java.util.Optional;

import ua.tqs.airportManager.entity.Reservation;

public interface ReservationService {
    
    Reservation createReservation(Reservation reservation);
    Optional<Reservation> getReservationByReservationId(String reservationId);
    List<Reservation> getReservationsByPassengerId(String passengerId);
    List<Reservation> getAllReservations();
}
