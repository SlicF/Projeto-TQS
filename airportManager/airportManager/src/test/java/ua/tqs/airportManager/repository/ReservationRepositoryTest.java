// package ua.tqs.airportManager.repository;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import ua.tqs.airportManager.entity.Airline;
// import ua.tqs.airportManager.entity.Flight;
// import ua.tqs.airportManager.entity.Passenger;
// import ua.tqs.airportManager.entity.Reservation;

// @DataJpaTest
// public class ReservationRepositoryTest {

//     @Autowired
//     private ReservationRepository reservationRepository;

//     @Autowired
//     private PassengerRepository passegerRepository;

//     @Autowired
//     private FlightRepository flightRepository;

//     @Autowired
//     private AirlineRepository airlineRepository;

//     @DisplayName("Test findByReservationId")
//     @Test
//     public void testFindByReservationId() {

//         Flight flight;
//         Airline airline = new Airline("EX", "Example Air");

//         airlineRepository.save(airline);

//         flight = new Flight("ABC123", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100", "Scheduled",
//                 100, airline);

//         flightRepository.save(flight);

//         Passenger passenger = new Passenger();
//         passenger.setPassengerId("1");
//         passenger.setFirstName("John");
//         passenger.setLastName("Doe");
//         passenger.setBirthDate(LocalDate.parse("1990-01-01"));
//         passenger.setCardNumber("1234567890123456");
//         passenger.setCountry("Portugal");
//         passenger.setState("Porto");
//         passenger.setStreetAddress("Rua de Camões");
//         passenger.setCardPIN("1234");
//         passenger.setPhoneNumber("912345678");
//         passenger.setEmail("email@email.com");
//         passenger.setSex("M");
//         passenger.setCity("Porto");
//         passenger.setPassportNumber("123456789");
//         passenger.setPostalCode("4000-000");

//         passegerRepository.save(passenger);
//         // Create a reservation
//         Reservation reservation = new Reservation();
//         reservation.setReservationId("1");
//         reservation.setPassengerId(passenger.getPassengerId());
//         reservation.setFlightId("ABC123");
//         reservation.setSeat("seat");
//         reservation.setTotalPrice(0.0);
//         reservation.setReservationDate(LocalDate.now());
//         reservation.setNameCard("nameCard");
//         reservation.setNumberCard("numberCard");
//         reservation.setExpirationDateCard("expirationDateCard");
//         reservation.setCountryCard("countryCard");
//         reservationRepository.save(reservation);

//         // Find the reservation by reservationId
//         Reservation foundReservation = reservationRepository.findByReservationId("1");

//         // Check if the found reservation is not null
//         assertNotNull(foundReservation);

//         // Check if the found reservation has the correct reservationId
//         assertEquals("1", foundReservation.getReservationId());
//     }

//     @DisplayName("Test findByPassengerId")
//     @Test
//     public void testFindByPassengerId() {
//         // Create reservations for a passenger
//         Reservation reservation1 = new Reservation();
//         reservation1.setReservationId("1");
//         reservation1.setPassengerId("123");
//         reservationRepository.save(reservation1);

//         Reservation reservation2 = new Reservation();
//         reservation2.setReservationId("2");
//         reservation2.setPassengerId("123");
//         reservationRepository.save(reservation2);

//         // Find reservations by passengerId
//         List<Reservation> foundReservations = reservationRepository.findByPassengerId("123");

//         // Check if the found reservations list is not null
//         assertNotNull(foundReservations);

//         // Check if the found reservations list has the correct size
//         assertEquals(2, foundReservations.size());

//         // Check if each reservation in the list has the correct passengerId
//         for (Reservation reservation : foundReservations) {
//             assertEquals("123", reservation.getPassengerId());
//         }
//     }
// }