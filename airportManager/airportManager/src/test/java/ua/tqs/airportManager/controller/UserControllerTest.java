// package ua.tqs.airportManager.controller;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import ua.tqs.airportManager.dto.AuthResponse;
// import ua.tqs.airportManager.dto.LoginDTO;
// import ua.tqs.airportManager.dto.RegisterDTO;
// import ua.tqs.airportManager.entity.User;
// import ua.tqs.airportManager.service.AuthService;
// import ua.tqs.airportManager.service.UserService;

// import java.util.*;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest(UserController.class)
// public class UserControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private AuthService authService;

//     @MockBean
//     private UserService userService;

//     @Test
//     public void testRegister() throws Exception {
//         RegisterDTO registerDTO = new RegisterDTO();
//         registerDTO.setFirstName("User");
//         registerDTO.setLastName("Test");
//         registerDTO.setEmail("testUser");
//         registerDTO.setUserPassword("testPassword");
//         registerDTO.setPassportNumber("123456789");
//         registerDTO.setCity("City");
//         registerDTO.setCountry("Country");

//         AuthResponse authResponse = new AuthResponse();
//         authResponse.setToken("testToken");

//         when(authService.register(any(RegisterDTO.class))).thenReturn(authResponse);

//         mockMvc.perform(post("/api/accounts/register")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content("{\"firstName\":\"User\",\"lastName\":\"Test\",\"email\":\"testUser\",\"password\":\"testPassword\",\"passportNumber\":\"123456789\",\"city\":\"City\",\"country\":\"Country\"}"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.token").value("testToken"));
//     }

//     @Test
//     public void testLogin() throws Exception {
//         LoginDTO loginDTO = new LoginDTO();
//         loginDTO.setEmail("testUser");
//         loginDTO.setPassword("testPassword");

//         AuthResponse authResponse = new AuthResponse();
//         authResponse.setToken("testToken");

//         when(authService.login(any(LoginDTO.class))).thenReturn(authResponse);

//         mockMvc.perform(post("/api/accounts/login")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content("{\"username\":\"testUser\",\"password\":\"testPassword\"}"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.token").value("testToken"));
//     }

//     @Test
//     public void testGetUserInfo() throws Exception {
//         User user = new User();
//         user.setUserId("testUserId");
//         user.setUsername("testUser");

//         when(userService.findByUserId("testUserId")).thenReturn(user);

//         mockMvc.perform(get("/api/accounts/userInfo")
//                 .param("userId", "testUserId"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.userId").value("testUserId"))
//                 .andExpect(jsonPath("$.username").value("testUser"));
//     }

//     @Test
//     public void testGetUserInfoByUsername() throws Exception {
//         User user = new User();
//         user.setUserId("testUserId");
//         user.setUsername("testUser");

//         when(userService.findByUsername(any())).thenReturn(Optional.of(user));

//         mockMvc.perform(get("/api/accounts/userInfoByUsername"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.userId").value("testUserId"))
//                 .andExpect(jsonPath("$.username").value("testUser"));
//     }

//     @Test
//     public void testGetUsers() throws Exception {
//         User user1 = new User();
//         user1.setUserId("testUserId1");
//         user1.setUsername("testUser1");

//         User user2 = new User();
//         user2.setUserId("testUserId2");
//         user2.setUsername("testUser2");

//         List<User> users = Arrays.asList(user1, user2);

//         when(userService.getAllUsers()).thenReturn(users);

//         mockMvc.perform(get("/api/accounts/users"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$[0].userId").value("testUserId1"))
//                 .andExpect(jsonPath("$[0].username").value("testUser1"))
//                 .andExpect(jsonPath("$[1].userId").value("testUserId2"))
//                 .andExpect(jsonPath("$[1].username").value("testUser2"));
//     }
// }