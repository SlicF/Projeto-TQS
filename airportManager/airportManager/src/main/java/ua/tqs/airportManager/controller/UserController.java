package ua.tqs.airportManager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.ReservationRepository;
import ua.tqs.airportManager.repository.UserRepository;
import ua.tqs.airportManager.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class UserController {

    // private AuthService authService;
    private UserService usersService;

    // @PostMapping("/register")
    // public ResponseEntity<User> register(@RequestBody RegisterDTO registerDTO) {
    //     return ResponseEntity.ok(authService.register(registerDTO));
    // }

    // @PostMapping("/login")
    // public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO) {
    //     return ResponseEntity.ok(authService.login(loginDTO));
    // }

    @GetMapping("/userInfo")
    public ResponseEntity<User> getUserInfo(@RequestParam("userID") String userID) {

        User user = usersService.findByUserId(userID);
       
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/userInfoByUsername")
    public ResponseEntity<User> getUserInfoByUsername(@RequestParam("username") String username) {

        User user = usersService.findByUsername(username);
       
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {

        List<User> users = usersService.getAllUsers();
       
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}