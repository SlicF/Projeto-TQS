// package ua.tqs.airportManager.controller;

// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import ua.tqs.airportManager.entity.Reservation;
// import ua.tqs.airportManager.entity.User;
// import ua.tqs.airportManager.repository.ReservationRepository;
// import ua.tqs.airportManager.service.UserService;

// public class UserControllerTest {

//     private MockMvc mockMvc;

//     @Mock
//     private UserService userService;

//     @InjectMocks
//     private UserController userController;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this);
//         mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//     }

//     @DisplayName("Test getUserInfo")
//     @Test
//     public void testGetUserInfo() throws Exception {
//         User user = new User();
//         user.setUserId("1");
//         user.setFirstName("user");
//         user.setLastName("test");

//         when(userService.findByUserId("1")).thenReturn(user);

//         mockMvc.perform(get("/api/accounts/userInfo")
//                 .param("userId", "1"))
//                 .andExpect(status().isOk());

//                 // .andExpect(jsonPath("$[0].userId").value("1"))
//                 // .andExpect(jsonPath("$.firstName").value("user"))
//                 // .andExpect(jsonPath("$.lastName").value("test"));
//     }

    
//     // @DisplayName("Test getUserInfoByUsername")
//     // @Test
//     // public void testGetUserInfoByUsername() throws Exception {
//     //     User user = new User();
//     //     user.setUserId("1");
//     //     user.setFirstName("user");
//     //     user.setLastName("test");
//     //     user.setUsername("user123");

//     //     System.out.println("user: " + user);

//     //     when(userService.findByUsername("user123")).thenReturn(user);

//     //     mockMvc.perform(get("/api/accounts/userInfoByUsername")
//     //             .param("username", "user123"))
//     //             .andExpect(status().isOk());

//     //             // .andExpect(jsonPath("$.userId").value("1"))
//     //             // .andExpect(jsonPath("$.firstName").value("user"))
//     //             // .andExpect(jsonPath("$.lastName").value("test"))
//     //             // .andExpect(jsonPath("$.username").value("user123"));
//     // }

//     @DisplayName("Test getUsers")
//     @Test
//     public void testGetUsers() throws Exception {
//         List<User> users = new ArrayList<>();

//         User user = new User();
//         user.setUserId("1");
//         user.setFirstName("user");
//         user.setLastName("test");
//         user.setUsername("user123");

//         users.add(user);

//         when(userService.getAllUsers()).thenReturn(users);

//         mockMvc.perform(get("/api/accounts/users")
//                 .param("userId", "1"))
//                 .andExpect(status().isOk());

//                 // .andExpect(jsonPath("$.userId").value("1"))
//                 // .andExpect(jsonPath("$.firstName").value("user"))
//                 // .andExpect(jsonPath("$.lastName").value("test"))
//                 // .andExpect(jsonPath("$.username").value("user123"));
//     }

//     // @DisplayName("Test getReservationsByUser")
//     // @Testperform(get("/api/accounts/userInfo")
//     // .param("userId", "1"))
//     // .param("firstName", "user")
//     // .param("lastName", "test")
//     // .andExpect(status().isOk());
//     // public void testGetReservationsByUser() throws Exception {
//     //     List<Reservation> reservations = new ArrayList<>();
//     //     reservations.add(new Reservation());
//     //     reservations.add(new Reservation());

//     //     when(reservationRepository.findByPassengerId("1")).thenReturn(reservations);

//     //     mockMvc.perform(get("/api/user/getReservationsByUser")
//     //             .param("userID", "1"))
//     //             .andExpect(status().isOk());
//     // }
// }

