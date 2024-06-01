package ua.tqs.airportManager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.service.ReservationService;

@CrossOrigin(origins = "http://localhost:8981")
@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;
    
    @PostMapping("/createReservation")
    public ResponseEntity<?> createReservation(@RequestBody Reservation reserv) {
        
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // String username = authentication.getName(); 
        // User user = UserRepository.findByUsername(username).orElseThrow();
        
        var reservation = reservationService.createReservation(reserv);
        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating reservation");
        }
        else {
            Map<String, Object> response = new HashMap<>();
            response.put("reservationId", reservation.getReservationId());
            return ResponseEntity.ok().body(response);
        }
    }

    @GetMapping("/getAllReservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/getReservation/{reservationId}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("reservationId") String reservationId) {
        Reservation reservation = reservationService.getReservationByReservationId(reservationId);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @GetMapping("/getReservationsByPassenger")
    public ResponseEntity<List<Reservation>> getReservationsByPassenger(@RequestParam("passengerId") String passengerId) {
        // array of reservations
        List<Reservation> reservations = reservationService.getReservationsByPassengerId(passengerId);
        
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
}
