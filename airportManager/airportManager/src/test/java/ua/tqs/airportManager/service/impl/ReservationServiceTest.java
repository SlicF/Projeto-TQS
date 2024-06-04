package ua.tqs.airportManager.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.repository.ReservationRepository;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    private Reservation reservation;

    @BeforeEach
    void setUp() {
        reservation = new Reservation();
        reservation.setReservationId("R123");
        reservation.setPassengerId("P123");
        reservation.setFlightId("F123");
    }

    @Test
    void testCreateReservation() {
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        Reservation createdReservation = reservationService.createReservation(reservation);

        assertNotNull(createdReservation);
        assertEquals(reservation.getReservationId(), createdReservation.getReservationId());
    }


    @Test
    void testGetReservationsByPassengerId() {
        Reservation reservation2 = new Reservation();
        reservation2.setReservationId("R124");
        reservation2.setPassengerId("P123");
        reservation2.setFlightId("F124");

        when(reservationRepository.findByPassengerId(anyString())).thenReturn(Arrays.asList(reservation, reservation2));

        List<Reservation> reservations = reservationService.getReservationsByPassengerId("P123");

        assertNotNull(reservations);
        assertEquals(2, reservations.size());
    }

    @Test
    void testGetAllReservations() {
        Reservation reservation2 = new Reservation();
        reservation2.setReservationId("R124");
        reservation2.setPassengerId("P124");
        reservation2.setFlightId("F124");

        when(reservationRepository.findAll()).thenReturn(Arrays.asList(reservation, reservation2));

        List<Reservation> allReservations = reservationService.getAllReservations();

        assertNotNull(allReservations);
        assertEquals(2, allReservations.size());
    }
}
