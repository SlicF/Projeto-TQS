package ua.tqs.airportManager.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.tqs.airportManager.entity.Passenger;
import ua.tqs.airportManager.repository.PassengerRepository;

@ExtendWith(MockitoExtension.class)
class PassengerServiceTest {

    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private PassengerServiceImpl passengerService;

    private Passenger passenger;

    @BeforeEach
    void setUp() {
        passenger = new Passenger();
        passenger.setPassengerId("P123");
        passenger.setFirstName("John Doe");
        passenger.setState("Active");
        passenger.setUserId(1);
    }

    @Test
    void testCreatePassenger() {
        when(passengerRepository.save(any(Passenger.class))).thenReturn(passenger);

        Passenger createdPassenger = passengerService.createPassenger(passenger);

        assertNotNull(createdPassenger);
        assertEquals(passenger.getPassengerId(), createdPassenger.getPassengerId());
    }


    @Test
    void testFindByState() {
        Passenger passenger2 = new Passenger();
        passenger2.setPassengerId("P124");
        passenger2.setFirstName("Jane Doe");
        passenger2.setState("Active");
        passenger2.setUserId(2);

        when(passengerRepository.findByState(anyString())).thenReturn(Arrays.asList(passenger, passenger2));

        List<Passenger> passengers = passengerService.findByState("Active");

        assertNotNull(passengers);
        assertEquals(2, passengers.size());
    }

    @Test
    void testGetAllPassengers() {
        Passenger passenger2 = new Passenger();
        passenger2.setPassengerId("P124");
        passenger2.setFirstName("Jane Doe");
        passenger2.setState("Active");
        passenger2.setUserId(2);

        when(passengerRepository.findAll()).thenReturn(Arrays.asList(passenger, passenger2));

        List<Passenger> allPassengers = passengerService.getAllPassengers();

        assertNotNull(allPassengers);
        assertEquals(2, allPassengers.size());
    }

    @Test
    void testFindByUserId() {
        Passenger passenger2 = new Passenger();
        passenger2.setPassengerId("P125");
        passenger2.setFirstName("Jake Doe");
        passenger2.setState("Inactive");
        passenger2.setUserId(1);

        when(passengerRepository.findByUserId(anyInt())).thenReturn(Arrays.asList(passenger, passenger2));

        List<Passenger> passengers = passengerService.findByUserId(1);

        assertNotNull(passengers);
        assertEquals(2, passengers.size());
    }
}
