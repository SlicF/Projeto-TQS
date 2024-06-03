package ua.tqs.airportManager.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.tqs.airportManager.Roles;

public class UserTest {
    
    private static User user;

    @BeforeAll
    public static void setUp() {
        user = new User();
        user.setUserId("1");
        user.setFirstName("João");
        user.setLastName("Neves");
        user.setUsername("joaoNeves");
        user.setPassword("password123");
        user.setEmail("joaoNeves@gmail.com");
        user.setPassportNumber("A12485");
        user.setCity("Porto");
        user.setCountry("Portugal");
        user.setRole(Roles.USER);
    }

    @DisplayName("Test User Entity")
    @Test
    void getUserTest() {
        assertAll(
            () -> assertEquals("1", user.getUserId()),
            () -> assertEquals("João", user.getFirstName()),
            () -> assertEquals("Neves", user.getLastName()),
            () -> assertEquals("joaoNeves", user.getUsername()),
            () -> assertEquals("password123", user.getPassword()),
            () -> assertEquals("joaoNeves@gmail.com", user.getEmail()),
            () -> assertEquals("A12485", user.getPassportNumber()),
            () -> assertEquals("Porto", user.getCity()),
            () -> assertEquals("Portugal", user.getCountry()),
            () -> assertEquals(Roles.USER, user.getRole())
        );
    }

    @Test
    @DisplayName(" Test if user is correctly added to the list")
    public void userAddedToListTest() {
        assertEquals("1", user.getUserId());
    }

    @Test
    @DisplayName(" Test if user details are correct")
    public void getUserDetailsTest() {
        assertEquals("João", user.getFirstName());
        assertEquals("Neves", user.getLastName());
        assertEquals("joaoNeves", user.getUsername());
        assertEquals("password123", user.getPassword());
        
    }




}