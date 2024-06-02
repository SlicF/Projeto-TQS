package ua.tqs.airportManager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.UserRepository;
import ua.tqs.airportManager.service.UserService;
import ua.tqs.airportManager.service.AuthService;
import ua.tqs.airportManager.dto.AuthResponse;
import ua.tqs.airportManager.dto.LoginDTO;
import ua.tqs.airportManager.dto.RegisterDTO;

@CrossOrigin(origins = "http://localhost:8981")
@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final AuthService authService;
    private final UserService usersService;
    private final UserRepository userRespository;

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
    public ResponseEntity<User> getUserInfoByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        logger.info("username: {}", username);

        User user = userRespository.findByUsername(username).orElseThrow();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = usersService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
