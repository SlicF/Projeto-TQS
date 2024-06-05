package ua.tqs.airportManager.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserId(1);
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("password123");
    }

    @Test
    void testRegistUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.registUser(user);

        assertNotNull(createdUser);
        assertEquals(user.getUsername(), createdUser.getUsername());
    }

    @Test
    void testFindByUserId() {
        when(userRepository.findByUserId(anyInt())).thenReturn(user);

        User foundUser = userService.findByUserId(1);

        assertNotNull(foundUser);
        assertEquals(1, foundUser.getUserId());
        assertEquals("testUser", foundUser.getUsername());
    }

    @Test
    void testFindByUsername() {
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.findByUsername("testUser");

        assertTrue(foundUser.isPresent());
        assertEquals("testUser", foundUser.get().getUsername());
    }

    @Test
    void testGetAllUsers() {
        User user2 = new User();
        user2.setUserId(2);
        user2.setUsername("secondUser");
        user2.setEmail("second@example.com");
        user2.setPassword("password456");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user, user2));

        List<User> allUsers = userService.getAllUsers();

        assertNotNull(allUsers);
        assertEquals(2, allUsers.size());
        assertEquals("testUser", allUsers.get(0).getUsername());
        assertEquals("secondUser", allUsers.get(1).getUsername());
    }

    @Test
    void testAuthenticateUser() {
        when(userRepository.findByUsernameAndPassword(anyString(), anyString())).thenReturn(user);

        User authenticatedUser = userService.authenticateUser("test@example.com", "password123");

        assertNotNull(authenticatedUser);
        assertEquals("testUser", authenticatedUser.getUsername());
        assertEquals("password123", authenticatedUser.getPassword());
    }
}
