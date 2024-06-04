package ua.tqs.airportManager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ua.tqs.airportManager.dto.RegisterDTO;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.UserRepository;
import ua.tqs.airportManager.service.AuthService;
import ua.tqs.airportManager.service.UserService;

import ua.tqs.airportManager.dto.AuthResponse;
import ua.tqs.airportManager.dto.LoginDTO;

@CrossOrigin(origins = "http://localhost:8981")
@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class UserController {

    private AuthService authService;
    private UserService userService;
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
    public ResponseEntity<User> getUserInfo(@RequestParam("userId") int userId) {

        User user = userService.findByUserId(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/userInfoByUsername")
    public ResponseEntity<User> getUserInfoByUsername(@RequestParam("username") String username) {

        User user = userRespository.findByUsername(username).orElseThrow();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
