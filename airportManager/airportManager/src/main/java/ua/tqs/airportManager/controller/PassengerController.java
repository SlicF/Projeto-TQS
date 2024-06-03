package ua.tqs.airportManager.controller;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Passenger;
import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.ReservationRepository;
import ua.tqs.airportManager.service.PassengerService;

import ua.tqs.airportManager.repository.PassengerRepository;

@CrossOrigin(origins = "http://localhost:8981")
@RestController
@AllArgsConstructor
@RequestMapping("/api/passengers")
public class PassengerController {
  
    // private AuthService authService;
    private PassengerService passengersService;

    @GetMapping("/passengers")
    public ResponseEntity<List<Passenger>> getPassengers() {

        List<Passenger> passengers = passengersService.getAllPassengers();

        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @GetMapping("/passengerInfo")
    public ResponseEntity<Passenger> getPassengerInfo(@RequestParam("passengerId") String passengerId) {

        Passenger passenger = passengersService.findByPassengerId(passengerId);

        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @GetMapping("/passengers/{state}")
    public ResponseEntity<List<Passenger>> getPassengerInfoByState(@PathVariable("state") String state) {

        List<Passenger> passengers = passengersService.findByState(state);

        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @PostMapping("/createPassenger")
    public ResponseEntity<?> createPassenger(@RequestBody Passenger passeng) {

        // Authentication authentication =
        // SecurityContextHolder.getContext().getAuthentication();
        // String username = authentication.getName();
        // User user = UserRepository.findByUsername(username).orElseThrow();

        var passenger = passengersService.createPassenger(passeng);
        if (passenger == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating passenger");
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("passengerId", passenger.getPassengerId());
            // return ResponseEntity.ok().body(response);
            return ResponseEntity.ok().body(passenger);

        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Passenger>> getPassengersByUserId(@PathVariable("userId") int userId) {
        List<Passenger> passengers = passengersService.findByUserId(userId);
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

}