package ua.tqs.airportManager.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.ReservationRepository;
import ua.tqs.airportManager.repository.UserRepository;

public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @DisplayName("Test getUserInfo")
    @Test
    public void testGetUserInfo() throws Exception {
        User user = new User();
        user.setUserId("1");

        when(userRepository.findByUserId("1")).thenReturn(user);

        mockMvc.perform(get("/api/user/userinfo")
                .param("userID", "1"))
                .andExpect(status().isOk());
    }

    @DisplayName("Test getReservationsByUser")
    @Test
    public void testGetReservationsByUser() throws Exception {
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation());
        reservations.add(new Reservation());

        when(reservationRepository.findByPassengerId("1")).thenReturn(reservations);

        mockMvc.perform(get("/api/user/getReservationsByUser")
                .param("userID", "1"))
                .andExpect(status().isOk());
    }
}