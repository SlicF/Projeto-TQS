package ua.tqs.airportManager.service;

import java.util.List;
import ua.tqs.airportManager.entity.Reservation;

public interface ReservationService {
    
    Reservation createReservation(Reservation reservation);
    Reservation getReservationByReservationId(String reservationId);
    List<Reservation> getReservationsByPassengerId(String passengerId);
    List<Reservation> getAllReservations();
}
