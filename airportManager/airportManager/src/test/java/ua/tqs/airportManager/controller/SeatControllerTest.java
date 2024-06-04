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

import ua.tqs.airportManager.entity.Seat;
import ua.tqs.airportManager.service.SeatService;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class SeatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock   
    private SeatService seatService;

    @InjectMocks
    private SeatController seatController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(seatController).build();
    }

    @Test
    void testGetSeats() throws Exception {
        List<Seat> seats = Arrays.asList(new Seat("S123", "1A", "F123", null));
        when(seatService.getAllSeats()).thenReturn(seats);

        mockMvc.perform(get("/api/seats/seats"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].seatId").value("S123"))
                .andExpect(jsonPath("$[0].seatNumber").value("1A"))
                .andExpect(jsonPath("$[0].flightId").value("F123"));
    }

    @Test
    void testGetSeatsByFlight() throws Exception {
        List<Seat> seats = Arrays.asList(new Seat("S123", "1A", "F123", null));
        when(seatService.getSeatByFlightId(anyString())).thenReturn(seats);

        mockMvc.perform(get("/api/seats/seatsByFlight")
                .param("flightId", "F123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].seatId").value("S123"))
                .andExpect(jsonPath("$[0].seatNumber").value("1A"))
                .andExpect(jsonPath("$[0].flightId").value("F123"));
    }

    @Test
    void testGetSeatInfo() throws Exception {
        Seat seat = new Seat("S123", "1A", "F123", null);
        when(seatService.getSeatBySeatId(anyString())).thenReturn(seat);

        mockMvc.perform(get("/api/seats/seatInfo")
                .param("seatId", "S123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.seatId").value("S123"))
                .andExpect(jsonPath("$.seatNumber").value("1A"))
                .andExpect(jsonPath("$.flightId").value("F123"));
    }

    @Test
    void testCreateSeat() throws Exception {
        Seat seat = new Seat("S123", "1A", "F123", null);
        when(seatService.createSeat(any(Seat.class))).thenReturn(seat);

        mockMvc.perform(post("/api/seats/createSeat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(seat)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.seatId").value("S123"));
    }
}

