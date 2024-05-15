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
import ua.tqs.airportManager.repository.UserRepository;
import ua.tqs.airportManager.service.ReservationService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    // private AuthService authService;
    private UserRepository usersRespository;
    private ReservationRepository reservationRepository;
    // private PassengerRepository passengerRespository;

    // @PostMapping("/register")
    // public ResponseEntity<AuthResponse> register(@RequestBody RegisterDTO registerDTO) {
    //     return ResponseEntity.ok(authService.register(registerDTO));
    // }

    // @PostMapping("/login")
    // public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO loginDTO) {
    //     return ResponseEntity.ok(authService.login(loginDTO));
    // }

    @GetMapping("/userinfo")
    public ResponseEntity<User> getUserInfo(@RequestParam("userID") String userID) {
        
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // String username = authentication.getName(); 
        // System.out.println("username: " + username);

        User user = usersRespository.findByUserId(userID);
       
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getReservationsByUser")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@RequestParam("userID") String userID) {
        //Array of reservations
        List<Reservation> reservations = new ArrayList<Reservation>();
        
        reservations = reservationRepository.findByUserId(userID);
        
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }


    // @GetMapping("/getReservationsByPassenger")
    // public ResponseEntity<List<Reservation>> getReservationsByPassenger() {
    //     // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     // String username = authentication.getName(); 

    //     // devia usar o passenger???
    //     //??????????????????????????
    //     Passenger passenger = passengerRespository.findByUsername(passengername).orElseThrow(); 

    //     List<Reservation> reservations = ReservationService.findReservationsByPassenger(passenger);
    //     return new ResponseEntity<>(reservations, HttpStatus.OK);
    // }
}