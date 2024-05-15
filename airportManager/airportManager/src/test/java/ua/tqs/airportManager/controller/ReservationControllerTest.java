package ua.tqs.airportManager.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.service.ReservationService;

public class ReservationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
    }

    @DisplayName("Test createReservation")
    @Test
    public void testCreateReservation() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setReservationId("1");

        when(reservationService.createReservation(reservation)).thenReturn(reservation);

        mockMvc.perform(post("/api/reservations/createReservation")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"reservationId\": 1}"))
                .andExpect(status().isOk());
    }

    @DisplayName("Test getAllReservations")
    @Test
    public void testGetAllReservations() throws Exception {
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation());
        reservations.add(new Reservation());

        when(reservationService.getAllReservations()).thenReturn(reservations);

        mockMvc.perform(get("/api/reservations/getAllReservations"))
                .andExpect(status().isOk());
    }

    @DisplayName("Test getReservation")
    @Test
    public void testGetReservation() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setReservationId("1");

        when(reservationService.getReservationByReservationId("1")).thenReturn(reservation);

        mockMvc.perform(get("/api/reservations/getReservation/1"))
                .andExpect(status().isOk());
    }
}