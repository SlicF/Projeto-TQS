package ua.tqs.airportManager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.ReservationRepository;
import ua.tqs.airportManager.repository.UserRepository;
import ua.tqs.airportManager.service.UserService;
import ua.tqs.airportManager.service.AuthService;

// import ua.ies.TravelingBooking.TravelingBooking.entity.User;
// import ua.ies.TravelingBooking.TravelingBooking.repository.UsersRepository;
// import ua.ies.TravelingBooking.TravelingBooking.service.AuthService;
import org.springframework.security.core.Authentication;
import ua.tqs.airportManager.dto.AuthResponse;
import ua.tqs.airportManager.dto.LoginDTO;
import ua.tqs.airportManager.dto.RegisterDTO;
// import ua.tqs.airportManager.dto.UserInfoDTO;

@CrossOrigin(origins = "http://localhost:8981")
@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class UserController {

    private AuthService authService;
    private UserService usersService;
    private UserRepository userRespository;


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterDTO registerDTO) {
    return ResponseEntity.ok(authService.register(registerDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO loginDTO) {
    return ResponseEntity.ok(authService.login(loginDTO));
    }

    @GetMapping("/userInfo")
    public ResponseEntity<User> getUserInfo(@RequestParam("userId") String userId) {

        User user = usersService.findByUserId(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/userInfoByUsername")
    // public ResponseEntity<User> getUserInfoByUsername(@RequestParam("username")
    // String username) {
    public ResponseEntity<User> getUserInfoByUsername() {

        // User user = usersService.findByUsername(username);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println("username: " + username);

        User user = userRespository.findByUsername(username).orElseThrow();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {

        List<User> users = usersService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}