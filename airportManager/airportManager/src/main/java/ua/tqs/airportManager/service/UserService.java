package ua.tqs.airportManager.service;

import java.util.List;
import java.util.Optional;

import ua.tqs.airportManager.entity.User;

public interface UserService {
    
    User registUser(User user);
    User findByUserId (String userId);
    User findByUsername (String username);
    List<User> getAllUsers();

    //autenticação
    User authenticateUser(String email, String password);
    // User getUser(String email);

}