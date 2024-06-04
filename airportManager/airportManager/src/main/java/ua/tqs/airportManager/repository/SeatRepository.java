package ua.tqs.airportManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.tqs.airportManager.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, String> {

    List<Seat> findByFlightId(String flightId);
    Seat findBySeatId(String seatId);
}

