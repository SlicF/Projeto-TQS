package ua.tqs.airportManager.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ua.tqs.airportManager.entity.Passenger;
import ua.tqs.airportManager.repository.PassengerRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PassengerControllerTest {

    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private PassengerController passengerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test getPassengers")
    void testGetPassengers() {
        // Arrange
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger());

        when(passengerRepository.findAll()).thenReturn(passengers);

        // Act
        ResponseEntity<List<Passenger>> response = passengerController.getPassengers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(passengers, response.getBody());
        verify(passengerRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test getPassengerInfo")
    void testGetPassengerInfo() {
        // Arrange
        String passengerId = "123456789";
        Passenger passenger = new Passenger();

        when(passengerRepository.findByPassengerId(passengerId)).thenReturn(passenger);

        // Act
        ResponseEntity<Passenger> response = passengerController.getPassengerInfo(passengerId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(passenger, response.getBody());
        verify(passengerRepository, times(1)).findByPassengerId(passengerId);
    }

    @Test
    @DisplayName("Test getPassengerInfoByState")
    void testGetPassengerInfoByState() {
        // Arrange
        String state = "active";
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger());

        when(passengerRepository.findByState(state)).thenReturn(passengers);

        // Act
        ResponseEntity<List<Passenger>> response = passengerController.getPassengerInfoByState(state);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(passengers, response.getBody());
        verify(passengerRepository, times(1)).findByState(state);
    }
}