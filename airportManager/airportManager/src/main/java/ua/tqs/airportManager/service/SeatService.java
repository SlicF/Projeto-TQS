package ua.tqs.airportManager.service;

import ua.tqs.airportManager.entity.Seat;
import java.util.List;

public interface SeatService {

    Seat createSeat(Seat seat);
    List<Seat> getSeatByFlightId(String flightId);
    Seat getSeatBySeatId(String seatId);
    List<Seat> getAllSeats();
}
