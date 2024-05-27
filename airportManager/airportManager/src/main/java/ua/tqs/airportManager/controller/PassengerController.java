package ua.tqs.airportManager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.tqs.airportManager.entity.Passenger;
import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.ReservationRepository;
import ua.tqs.airportManager.repository.PassengerRepository;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    // private AuthService authService;
    private PassengerRepository passengersRespository;

    @GetMapping("/passengers")
    public ResponseEntity<List<Passenger>> getPassengers() {

        List<Passenger> passengers = passengersRespository.findAll();
       
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @GetMapping("/passengerInfo")
    public ResponseEntity<Passenger> getPassengerInfo(@RequestParam("passengerId") String passengerId) {

        Passenger passenger = passengersRespository.findByPassengerId(passengerId);
       
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @GetMapping("/passengers/{state}")
    public ResponseEntity<List<Passenger>> getPassengerInfoByState(@PathVariable("state") String state) {

        List<Passenger> passengers = passengersRespository.findByState(state);
       
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }
}