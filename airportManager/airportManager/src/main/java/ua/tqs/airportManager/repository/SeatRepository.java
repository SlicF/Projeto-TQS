// package ua.tqs.airportManager.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import ua.tqs.airportManager.entity.Airline;
// import ua.tqs.airportManager.entity.Seat;

// @Repository

package ua.tqs.airportManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.tqs.airportManager.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, String> {

    List<Seat> findByFlightId(String flightId);
    Seat findBySeatId(String seatId);
}

