package ua.tqs.airportManager.controller;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ua.tqs.airportManager.entity.Passenger;
import ua.tqs.airportManager.service.PassengerService;

@ExtendWith(MockitoExtension.class)
class PassengerControllerTest {

    @Mock
    private PassengerService passengerService;

    @InjectMocks
    private PassengerController passengerController;

    private Passenger passenger;

    @BeforeEach
    void setUp() {
        passenger = new Passenger();
        passenger.setPassengerId("P123");
        passenger.setFirstName("John");
        passenger.setLastName("Doe");
        passenger.setState("NY");
        passenger.setUserId(1);
    }

    @Test
    void testGetPassengers() {
        List<Passenger> passengers = Arrays.asList(passenger, new Passenger());
        when(passengerService.getAllPassengers()).thenReturn(passengers);

        ResponseEntity<List<Passenger>> response = passengerController.getPassengers();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(passengers);
        verify(passengerService, times(1)).getAllPassengers();
    }

    @Test
    void testGetPassengerInfo() {
        when(passengerService.findByPassengerId(anyString())).thenReturn(passenger);

        ResponseEntity<Passenger> response = passengerController.getPassengerInfo("P123");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(passenger);
        verify(passengerService, times(1)).findByPassengerId(anyString());
    }

    @Test
    void testGetPassengerInfoByState() {
        List<Passenger> passengers = Arrays.asList(passenger, new Passenger());
        when(passengerService.findByState(anyString())).thenReturn(passengers);

        ResponseEntity<List<Passenger>> response = passengerController.getPassengerInfoByState("NY");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(passengers);
        verify(passengerService, times(1)).findByState(anyString());
    }

    @Test
    void testCreatePassenger() {
        when(passengerService.createPassenger(any(Passenger.class))).thenReturn(passenger);

        ResponseEntity<?> response = passengerController.createPassenger(passenger);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(((Passenger) response.getBody()).getPassengerId()).isEqualTo("P123");
        verify(passengerService, times(1)).createPassenger(any(Passenger.class));
    }

    @Test
    void testCreatePassengerFailure() {
        when(passengerService.createPassenger(any(Passenger.class))).thenReturn(null);

        ResponseEntity<?> response = passengerController.createPassenger(passenger);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).isEqualTo("Error creating passenger");
        verify(passengerService, times(1)).createPassenger(any(Passenger.class));
    }

    @Test
    void testGetPassengersByUserId() {
        List<Passenger> passengers = Arrays.asList(passenger, new Passenger());
        when(passengerService.findByUserId(anyInt())).thenReturn(passengers);

        ResponseEntity<List<Passenger>> response = passengerController.getPassengersByUserId(1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(passengers);
        verify(passengerService, times(1)).findByUserId(anyInt());
    }
}
