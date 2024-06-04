package ua.tqs.airportManager.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.service.ReservationService;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
    }

    @Test
    @Disabled
    void testCreateReservation() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setReservationId("R123");
        
        when(reservationService.createReservation(any(Reservation.class))).thenReturn(reservation);

        mockMvc.perform(post("/api/reservations/createReservation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(reservation)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reservationId").value("R123"));
    }

    @Test
    @Disabled
    void testGetAllReservations() throws Exception {
        List<Reservation> reservations = Arrays.asList(new Reservation("R123", "P123", "F123", "Seat1", 100.0, null, "John Doe", "1234567890", "USA", null, null));
        when(reservationService.getAllReservations()).thenReturn(reservations);

        mockMvc.perform(get("/api/reservations/getAllReservations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].reservationId").value("R123"));
    }

    @Test
    void testGetReservation() throws Exception {
        Reservation reservation = new Reservation("R123", "P123", "F123", "Seat1", 100.0, null, "John Doe", "1234567890", "USA", null, null);
        when(reservationService.getReservationByReservationId(anyString())).thenReturn(reservation);

        mockMvc.perform(get("/api/reservations/getReservation/R123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reservationId").value("R123"));
    }

    @Test
    @Disabled
    void testGetReservationsByPassenger() throws Exception {
        List<Reservation> reservations = Arrays.asList(new Reservation("R123", "P123", "F123", "Seat1", 100.0, null, "John Doe", "1234567890", "USA", null, null));
        when(reservationService.getReservationsByPassengerId(anyString())).thenReturn(reservations);

        mockMvc.perform(get("/api/reservations/getReservationsByPassenger")
                .param("passengerId", "P123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].reservationId").value("R123"));
    }
}
