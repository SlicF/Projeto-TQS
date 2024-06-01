// package ua.tqs.airportManager.repository;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// import java.time.LocalDate;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import ua.tqs.airportManager.entity.Airline;
// import ua.tqs.airportManager.entity.Flight;
// import ua.tqs.airportManager.entity.Luggage;
// import ua.tqs.airportManager.entity.Passenger;
// import ua.tqs.airportManager.entity.Reservation;

// @DataJpaTest
// public class LuggageRepositoryTest {

//     @Autowired
//     private LuggageRepository luggageRepository;

//     @Autowired
//     private PassengerRepository passegerRepository;

//     @Autowired
//     private ReservationRepository reservationRepository;

//     @Autowired
//     private FlightRepository flightRepository;

//     @Autowired
//     private AirlineRepository airlineRepository;

//     @Test
//     void testSaveAndFindByLuggageId() {

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


//         // Given
//         Luggage luggage = new Luggage("1", "John Doe", "23", reservation);

//         // When
//         luggageRepository.save(luggage);
//         Luggage foundLuggage = luggageRepository.findByLuggageId("1");

//         // Then
//         assertNotNull(foundLuggage);
//         assertEquals("1", foundLuggage.getLuggageId());
//     }
// }