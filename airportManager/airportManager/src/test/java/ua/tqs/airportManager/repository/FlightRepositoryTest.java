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

// import ua.tqs.airportManager.entity.Airline;
// import ua.tqs.airportManager.entity.Flight;
// import ua.tqs.airportManager.service.FlightService;

// @DataJpaTest
// public class FlightRepositoryTest {

//     @Autowired
//     private TestEntityManager entityManager;

//     @Autowired
//     private FlightRepository flightRepository;

//     static Flight flight = new Flight("PTIT235", "TAP", "Portugal", "Itália", LocalDate.of(2024, 5, 19), "09h47", "12h53", "150€", "OK", 230, new ArrayList<>(), new Airline("TAP", "TAP Portugal"));

//     @BeforeEach
//     public void setup() {
//         flight = new Flight();
//         flight.setFlightId("PTIT235");
//         flight.setState("OK");
//         flight.setDepartureCity("City A");
//         flight.setArrivalCity("City B");
//         flight.setDate(LocalDate.now());

//         // entityManager.persist(flight);
//         // entityManager.flush();

//         flightRepository.save(flight);
//     }

//     @DisplayName("Test findByFlightId")
//     @Test
//     public void testFindByFlightId() {
//         Flight foundFlight = flightRepository.findByFlightId("PTIT235");

//         assertNotNull(foundFlight);
//         assertEquals("PTIT235", foundFlight.getFlightId());
//     }

//     @DisplayName("Test findByState")
//     @Test
//     public void testFindByState() {
//         List<Flight> foundFlights = flightRepository.findByState("OK");

//         assertNotNull(foundFlights);
//         assertEquals(1, foundFlights.size());
//         assertEquals(flight.getState(), foundFlights.get(0).getState());
//     }

//     @DisplayName("Test findByDepartureCityArrivalCityDate")
//     @Test
//     public void testFindByDepartureCityArrivalCityDate() {
//         List<Flight> foundFlights = flightRepository.findByDepartureCityAndArrivalCityAndDate("City A", "City B", LocalDate.now());

//         assertNotNull(foundFlights);
//         assertEquals(1, foundFlights.size());
//         assertEquals(flight.getDepartureCity(), foundFlights.get(0).getDepartureCity());
//         assertEquals(flight.getArrivalCity(), foundFlights.get(0).getArrivalCity());
//         assertEquals(flight.getDate(), foundFlights.get(0).getDate());
//     }
// }