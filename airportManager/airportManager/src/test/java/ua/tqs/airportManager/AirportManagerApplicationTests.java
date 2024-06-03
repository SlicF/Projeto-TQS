// package ua.tqs.airportManager;

// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import ua.tqs.airportManager.repository.UserRepository;
// import ua.tqs.airportManager.entity.User;

// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.when;

// @SpringBootTest
// @ActiveProfiles("test")
// class AirportManagerApplicationTests {

//     @MockBean
//     private UserRepository userRepository;

//     @Autowired
//     private UserRepository injectedUserRepository;

//     @Test
//     void contextLoads() {
//         assertNotNull(injectedUserRepository);
//     }

//     @Test
//     void testUserRepository() {
//         User mockUser = new User();
//         mockUser.setUsername("testuser");
//         when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(mockUser));

//         Optional<User> user = userRepository.findByUsername("testuser");
//         assertNotNull(user);
//         assertEquals("testuser", user.get().getUsername());
//     }

//     @Configuration
//     static class TestConfig {
//         @Bean
//         public UserRepository userRepository() {
//             return Mockito.mock(UserRepository.class);
//         }
//     }
// }
package ua.tqs.airportManager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class AirportManagerApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertNotNull(context, "The application context should have loaded.");
    }
}
