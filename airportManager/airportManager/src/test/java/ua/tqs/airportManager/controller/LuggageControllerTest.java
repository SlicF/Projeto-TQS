package ua.tqs.airportManager.controller;

import static org.mockito.ArgumentMatchers.any;
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

import ua.tqs.airportManager.entity.Luggage;
import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.service.LuggageService;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class LuggageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private LuggageService luggageService;

    @InjectMocks
    private LuggageController luggageController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(luggageController).build();
    }

    
    @Test
    @Disabled
    void testGetAllLuggage() throws Exception {
        Reservation reservation = new Reservation();
        List<Luggage> luggages = Arrays.asList(new Luggage("L123", "R123", "20.5", reservation));
        when(luggageService.getAllLuggages()).thenReturn(luggages);

        mockMvc.perform(get("/api/luggage/luggage"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].luggageId").value("L123"))
                .andExpect(jsonPath("$[0].reservationId").value("R123"))
                .andExpect(jsonPath("$[0].weight").value("20.5"));
    }

    @Test
    @Disabled
    void testCreateLuggage() throws Exception {
        Reservation reservation = new Reservation();
        Luggage luggage = new Luggage("L123", "R123", "20.5", reservation);
        when(luggageService.createLuggage(any(Luggage.class))).thenReturn(luggage);

        mockMvc.perform(post("/api/luggage/createLuggage")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(luggage)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.luggageId").value("L123"))
                .andExpect(jsonPath("$.reservationId").value("R123"))
                .andExpect(jsonPath("$.weight").value("20.5"));
    }
}
