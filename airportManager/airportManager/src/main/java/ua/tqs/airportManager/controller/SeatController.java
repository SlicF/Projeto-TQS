package ua.tqs.airportManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Seat;
import ua.tqs.airportManager.service.SeatService;

@CrossOrigin(origins = "http://*:8981")
@RestController
@AllArgsConstructor
@RequestMapping("/api/seats")
public class SeatController {

    // private AuthService authService;
    private SeatService seatsService;

    @GetMapping("/seats")
    public ResponseEntity<List<Seat>> getSeats() {

        List<Seat> seats = seatsService.getAllSeats();
       
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @GetMapping("/seatsByFlight")
    public ResponseEntity<List<Seat>> getSeatsByFlight(@RequestParam("flightId") String flightId) {

        List<Seat> seats = seatsService.getSeatByFlightId(flightId);
       
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @GetMapping("/seatInfo")
    public ResponseEntity<Seat> getSeatInfo(@RequestParam("seatId") String seatId) {

        Seat seat = seatsService.getSeatBySeatId(seatId);
       
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }

    @PostMapping("/createSeat")
    public ResponseEntity<?> createSeat(@RequestBody Seat passeng) {
        
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // String username = authentication.getName(); 
        // User user = UserRepository.findByUsername(username).orElseThrow();

        var seat = seatsService.createSeat(passeng);
        if (seat == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating seat");
        }
        else {
            Map<String, Object> response = new HashMap<>();
            response.put("seatId", seat.getSeatId());
            return ResponseEntity.ok().body(response);
        }
    }
}