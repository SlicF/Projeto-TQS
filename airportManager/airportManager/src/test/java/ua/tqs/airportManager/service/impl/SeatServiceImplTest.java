package ua.tqs.airportManager.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.tqs.airportManager.entity.Seat;
import ua.tqs.airportManager.repository.SeatRepository;

public class SeatServiceImplTest {

    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private SeatServiceImpl seatService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateSeat() {
        Seat seat = new Seat();
        seat.setSeatId("S123");

        when(seatRepository.save(any(Seat.class))).thenReturn(seat);

        Seat createdSeat = seatService.createSeat(seat);

        assertNotNull(createdSeat);
        assertEquals("S123", createdSeat.getSeatId());
        verify(seatRepository, times(1)).save(any(Seat.class));
    }

    @Test
    public void testGetSeatByFlightId() {
        Seat seat1 = new Seat();
        seat1.setSeatId("S123");

        Seat seat2 = new Seat();
        seat2.setSeatId("S124");

        List<Seat> seats = Arrays.asList(seat1, seat2);

        when(seatRepository.findByFlightId("F123")).thenReturn(seats);

        List<Seat> foundSeats = seatService.getSeatByFlightId("F123");

        assertNotNull(foundSeats);
        assertEquals(2, foundSeats.size());
        verify(seatRepository, times(1)).findByFlightId("F123");
    }

  

    @Test
    public void testGetAllSeats() {
        Seat seat1 = new Seat();
        seat1.setSeatId("S123");

        Seat seat2 = new Seat();
        seat2.setSeatId("S124");

        List<Seat> seats = Arrays.asList(seat1, seat2);

        when(seatRepository.findAll()).thenReturn(seats);

        List<Seat> foundSeats = seatService.getAllSeats();

        assertNotNull(foundSeats);
        assertEquals(2, foundSeats.size());
        verify(seatRepository, times(1)).findAll();
    }
}