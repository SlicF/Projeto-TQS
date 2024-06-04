// package ua.tqs.airportManager;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Random;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import ua.tqs.airportManager.entity.Airline;
// import ua.tqs.airportManager.entity.Flight;
// import ua.tqs.airportManager.entity.Luggage;
// import ua.tqs.airportManager.entity.Passenger;
// import ua.tqs.airportManager.entity.Reservation;
// import ua.tqs.airportManager.entity.Seat;
// import ua.tqs.airportManager.entity.User;
// import ua.tqs.airportManager.repository.AirlineRepository;
// import ua.tqs.airportManager.repository.FlightRepository;
// import ua.tqs.airportManager.repository.LuggageRepository;
// import ua.tqs.airportManager.repository.PassengerRepository;
// import ua.tqs.airportManager.repository.ReservationRepository;
// import ua.tqs.airportManager.repository.SeatRepository;
// import ua.tqs.airportManager.repository.UserRepository;

// public class DataInitializerTest {

//     @Mock
//     private AirlineRepository airlineRepository;

//     @Mock
//     private FlightRepository flightRepository;

//     @Mock
//     private UserRepository userRepository;

//     @Mock
//     private PassengerRepository passengerRepository;

//     @Mock
//     private SeatRepository seatRepository;

//     @Mock
//     private ReservationRepository reservationRepository;

//     @Mock
//     private LuggageRepository luggageRepository;

//     @InjectMocks
//     private DataInitializer dataInitializer;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this);
//         dataInitializer.random = new Random();
//     }

//     @DisplayName("Test Data Initialization")
//     @Test
//     public void testInit() {
//         // Mocking the behavior of repository save and findAll methods
//         when(airlineRepository.findAll()).thenReturn(new ArrayList<>());
//         when(flightRepository.findAll()).thenReturn(new ArrayList<>());
//         when(userRepository.findAll()).thenReturn(new ArrayList<>());
//         when(passengerRepository.findAll()).thenReturn(new ArrayList<>());
//         when(reservationRepository.findAll()).thenReturn(new ArrayList<>());

//         // Call the init method to initialize the data
//         dataInitializer.init();

//         // Verify that the save method of each repository is called the correct number of times
//         verify(airlineRepository, times(14)).save(any(Airline.class));
//         verify(flightRepository, times(52)).save(any(Flight.class));
//         verify(userRepository, times(20)).save(any(User.class));
//         verify(passengerRepository, times(10)).save(any(Passenger.class));
//         verify(seatRepository, times(80)).save(any(Seat.class));
//         verify(reservationRepository, times(7)).save(any(Reservation.class));
//         verify(luggageRepository, times(5)).save(any(Luggage.class));
//     }

//     @DisplayName("Test Generate and Save Flights")
//     @Test
//     public void testGenerateAndSaveFlights() {
//         List<Airline> airlines = new ArrayList<>();
//         airlines.add(new Airline("TAP", "TAP Portugal"));

//         dataInitializer.generateAndSaveFlights(airlines);

//         verify(flightRepository, times(50)).save(any(Flight.class));
//     }

//     @DisplayName("Test Generate and Save Users")
//     @Test
//     public void testGenerateAndSaveUsers() {
//         dataInitializer.generateAndSaveUsers();

//         verify(userRepository, times(20)).save(any(User.class));
//     }

//     @DisplayName("Test Generate and Save Passengers")
//     @Test
//     public void testGenerateAndSavePassengers() {
//         List<User> users = new ArrayList<>();
//         users.add(new User("1", "username", "First", "Last", "password", "email", "passport", "city", "country", Roles.USER));
//         when(userRepository.findAll()).thenReturn(users);
//         dataInitializer.users = users;

//         dataInitializer.generateAndSavePassengers();

//         verify(passengerRepository, times(10)).save(any(Passenger.class));
//     }

//     @DisplayName("Test Generate and Save Seats")
//     @Test
//     public void testGenerateAndSaveSeats() {
//         List<Flight> flights = new ArrayList<>();
//         flights.add(new Flight("RYA9830", "RYA", "Viena", "Paris", LocalDate.of(2024, 6, 7), "07h45", "09h15", "100", "OK", 230, new Airline("RYA", "RyanAir Services")));
//         when(flightRepository.findAll()).thenReturn(flights);
//         dataInitializer.flights = flights;

//         dataInitializer.generateAndSaveSeats();

//         verify(seatRepository, times(80)).save(any(Seat.class));
//     }

//     @DisplayName("Test Generate and Save Reservations")
//     @Test
//     public void testGenerateAndSaveReservations() {
//         List<Passenger> passengers = new ArrayList<>();
//         passengers.add(new Passenger("1", "1", "First", "Last", "state", "sex", LocalDate.of(1990, 1, 1), "email", "phone", "passport", "postal", "street", "city", "country", "card", "pin", new User()));
//         when(passengerRepository.findAll()).thenReturn(passengers);
//         dataInitializer.passengers = passengers;

//         List<Flight> flights = new ArrayList<>();
//         flights.add(new Flight("RYA9830", "RYA", "Viena", "Paris", LocalDate.of(2024, 6, 7), "07h45", "09h15", "100", "OK", 230, new Airline("RYA", "RyanAir Services")));
//         when(flightRepository.findAll()).thenReturn(flights);
//         dataInitializer.flights = flights;

//         dataInitializer.generateAndSaveReservations();

//         verify(reservationRepository, times(7)).save(any(Reservation.class));
//     }

//     @DisplayName("Test Generate and Save Luggage")
//     @Test
//     public void testGenerateAndSaveLuggage() {
//         List<Reservation> reservations = new ArrayList<>();
//         reservations.add(new Reservation("1", "1", "1", "seat", 100.0, LocalDate.of(2024, 6, 7), "name", "card", "2024 - 06", "country", new Passenger(), new Flight()));
//         when(reservationRepository.findAll()).thenReturn(reservations);
//         dataInitializer.reservations = reservations;

//         dataInitializer.generateAndSaveLuggage();

//         verify(luggageRepository, times(5)).save(any(Luggage.class));
//     }
// }
