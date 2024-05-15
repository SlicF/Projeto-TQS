package ua.tqs.airportManager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.repository.ReservationRepository;
import ua.tqs.airportManager.service.ReservationService;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationByReservationId(String reservationId) {
        return reservationRepository.findByReservationId(reservationId);
    }

    @Override
    public List<Reservation> getReservationsByUserId(String userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}