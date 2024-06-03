// package ua.tqs.airportManager.entity;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// class PassengerTest {

//     @Test
//     void testPassengerId() {
//         Passenger passenger = new Passenger();
//         passenger.setPassengerId("ABC123");
//         assertEquals("ABC123", passenger.getPassengerId());
//     }

//     @Test
//     void testUserId() {
//         Passenger passenger = new Passenger();
//         passenger.setUserId("user123");
//         assertEquals("user123", passenger.getUserId());
//     }

//     @Test
//     void testFirstName() {
//         Passenger passenger = new Passenger();
//         passenger.setFirstName("John");
//         assertEquals("John", passenger.getFirstName());
//     }

//     @Test
//     void testLastName() {
//         Passenger passenger = new Passenger();
//         passenger.setLastName("Doe");
//         assertEquals("Doe", passenger.getLastName());
//     }

//     @Test
//     void testEmail() {
//         Passenger passenger = new Passenger();
//         passenger.setEmail("algo@algo.pt");
//         assertEquals("algo@algo.pt", passenger.getEmail());
//     }

//     @Test
//     void testPhone() {
//         Passenger passenger = new Passenger();
//         passenger.setPhoneNumber("123456789");
//         assertEquals("123456789", passenger.getPhoneNumber());
//     }

//     @Test
//     void testAddress() {
//         Passenger passenger = new Passenger();
//         passenger.setStreetAddress("Rua do Algo");
//         assertEquals("Rua do Algo", passenger.getStreetAddress());
//     }

//     @Test
//     void testCity() {
//         Passenger passenger = new Passenger();
//         passenger.setCity("Porto");
//         assertEquals("Porto", passenger.getCity());
//     }

//     @Test
//     void testCountry() {
//         Passenger passenger = new Passenger();
//         passenger.setCountry("Portugal");
//         assertEquals("Portugal", passenger.getCountry());
//     }

//     @Test
//     void testPostalCode() {
//         Passenger passenger = new Passenger();
//         passenger.setPostalCode("4000-007");
//         assertEquals("4000-007", passenger.getPostalCode());
//     }

//     @Test
//     void testState() {
//         Passenger passenger = new Passenger();
//         passenger.setState("Portugal");
//         assertEquals("Portugal", passenger.getState());
//     }

//     @Test
//     void testPassengerAssociation() {
//         Passenger passenger = new Passenger();
//         passenger.setPassengerId("ABC123");
//         assertEquals("ABC123", passenger.getPassengerId());
//     }

//     @Test
//     void testUserAssociation() {
//         Passenger passenger = new Passenger();
//         User user = new User();
//         user.setUserId("user123");
//         passenger.setUser(user);
//         assertEquals(user, passenger.getUser());
//     }
// }