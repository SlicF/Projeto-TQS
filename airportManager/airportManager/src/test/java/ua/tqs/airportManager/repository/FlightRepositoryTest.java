// package ua.tqs.airportManager.repository;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// import ua.tqs.airportManager.entity.Flight;

// @DataJpaTest
// public class FlightRepositoryTest {

//     @Autowired
//     private TestEntityManager entityManager;

//     @Autowired
//     private FlightRepository flightRepository;

//     private Flight flight;

//     @BeforeEach
//     public void setup() {
//         flight = new Flight();
//         flight.setFlightId("1");
//         flight.setState("Scheduled");
//         flight.setDepartureCity("City A");
//         flight.setArrivalCity("City B");
//         flight.setFlightDate(LocalDate.now());

//         entityManager.persist(flight);
//         entityManager.flush();
//     }

//     @DisplayName("Test findByFlightId")
//     @Test
//     public void testFindByFlightId() {
//         Flight foundFlight = flightRepository.findByFlightId("1");

//         assertNotNull(foundFlight);
//         assertEquals(flight.getFlightId(), foundFlight.getFlightId());
//     }

//     @DisplayName("Test findByState")
//     @Test
//     public void testFindByState() {
//         List<Flight> foundFlights = flightRepository.findByState("Scheduled");

//         assertNotNull(foundFlights);
//         assertEquals(1, foundFlights.size());
//         assertEquals(flight.getState(), foundFlights.get(0).getState());
//     }

//     @DisplayName("Test findByDepartureCityArrivalCityDate")
//     @Test
//     public void testFindByDepartureCityArrivalCityDate() {
//         List<Flight> foundFlights = flightRepository.findByDepartureCityArrivalCityDate("City A", "City B", LocalDate.now());

//         assertNotNull(foundFlights);
//         assertEquals(1, foundFlights.size());
//         assertEquals(flight.getDepartureCity(), foundFlights.get(0).getDepartureCity());
//         assertEquals(flight.getArrivalCity(), foundFlights.get(0).getArrivalCity());
//         assertEquals(flight.getFlightDate(), foundFlights.get(0).getFlightDate());
//     }
// }