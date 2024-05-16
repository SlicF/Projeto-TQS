package ua.tqs.airportManager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.ReservationRepository;
import ua.tqs.airportManager.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

    // private AuthService authService;
    private UserRepository usersRespository;
    private ReservationRepository reservationRepository;

    @GetMapping("/userinfo")
    public ResponseEntity<User> getUserInfo(@RequestParam("userID") String userID) {

        User user = usersRespository.findByUserId(userID);
       
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getReservationsByUser")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@RequestParam("userID") String passengerID) {
        //Array of reservations
        List<Reservation> reservations = new ArrayList<Reservation>();
        
        reservations = reservationRepository.findByPassengerId(passengerID);
        
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }


}