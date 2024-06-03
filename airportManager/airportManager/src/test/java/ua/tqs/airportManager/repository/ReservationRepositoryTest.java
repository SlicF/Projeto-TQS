// package ua.tqs.airportManager.repository;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// import ua.tqs.airportManager.entity.Reservation;

// @DataJpaTest
// public class ReservationRepositoryTest {

//     @Autowired
//     private TestEntityManager entityManager;

//     @Autowired
//     private ReservationRepository reservationRepository;

//     @DisplayName("Test findByReservationId")
//     @Test
//     public void testFindByReservationId() {
//         // Create a reservation
//         Reservation reservation = new Reservation();
//         reservation.setReservationId("1");
//         entityManager.persist(reservation);
//         entityManager.flush();

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
//         entityManager.persist(reservation1);

//         Reservation reservation2 = new Reservation();
//         reservation2.setReservationId("2");
//         reservation2.setPassengerId("123");
//         entityManager.persist(reservation2);

//         entityManager.flush();

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