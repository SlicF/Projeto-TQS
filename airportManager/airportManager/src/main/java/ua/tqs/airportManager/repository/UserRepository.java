package ua.tqs.airportManager.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    User findByUserId (String userId);
    User findByEmail (String email);
    Optional<User> findByUsername (String username);
    User findByUsernameAndPassword(String username, String password);

}
