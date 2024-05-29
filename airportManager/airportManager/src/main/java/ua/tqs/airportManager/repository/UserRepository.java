package ua.tqs.airportManager.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    User findByUserId (String userId);
    Optional<User> findByUsername (String username);
    // List<User> getAll();

    // Optional<User> findByUsername(String email);
}
