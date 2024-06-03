package ua.tqs.airportManager.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    User findByUserId (int userId);
    // Optional<User> findByEmail (String email);
    Optional<User> findByUsername (String username);
    // List<User> getAll();

    // User authenticateUser(String email, String password);
    User findByUsernameAndPassword(String username, String password);

    // Optional<User> findByUsername(String email);
}
