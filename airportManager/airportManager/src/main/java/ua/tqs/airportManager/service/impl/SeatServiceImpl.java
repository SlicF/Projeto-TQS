package ua.tqs.airportManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.tqs.airportManager.entity.Seat;
import ua.tqs.airportManager.repository.SeatRepository;
import ua.tqs.airportManager.service.SeatService;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> getSeatByFlightId(String flightId) {
        List<Seat> seat = seatRepository.findByFlightId(flightId);
        return seat;
    }

    @Override
    public Seat getSeatBySeatId(String seatId) {
        Seat seat = seatRepository.findBySeatId(seatId);
        return seat;
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }
}