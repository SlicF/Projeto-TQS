package ua.tqs.airportManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tqs.airportManager.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    User findByUserId (Integer userId);
    User findByUsername (String username);
}
