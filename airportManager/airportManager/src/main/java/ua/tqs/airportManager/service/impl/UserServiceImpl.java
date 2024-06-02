package ua.tqs.airportManager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.UserRepository;
import ua.tqs.airportManager.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    
    private UserRepository userRepository;

    @Override
    public User registUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserId (int userId) { 
        return userRepository.findByUserId(userId);
    }

    @Override
    public Optional<User> findByUsername (String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //autenticação

    @Override
    public User authenticateUser(String email, String password) {
        return userRepository.findByUsernameAndPassword(email, password);
    }
    
    // @Override
    // public User authenticateUser(String email, String password) {
    // }

}
