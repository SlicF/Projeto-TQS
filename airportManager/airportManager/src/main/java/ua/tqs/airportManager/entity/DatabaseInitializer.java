// package ua.tqs.airportManager.entity;

// import org.springframework.stereotype.Component;

// import ua.tqs.airportManager.repository.FlightRepository;
// import ua.tqs.airportManager.repository.ReservationRepository;
// import ua.tqs.airportManager.repository.UserRepository;

// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Date;

// import javax.annotation.PostConstruct;
// import java.text.ParseException;

// @Component
// public class DatabaseInitializer {

//     private final UserRepository userRepository;
//     private final FlightRepository flightRepository;
//     private final ReservationRepository reservationRepository;

//     public DatabaseInitializer(UserRepository userRepository, FlightRepository flightRepository,
//             ReservationRepository reservationRepository) {
//         this.userRepository = userRepository;
//         this.flightRepository = flightRepository;
//         this.reservationRepository = reservationRepository;
//     }

//     @PostConstruct
//     public void populateDatabase() {

//         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

//         // População da base de dados User
//         // ...

//         Flight flight1 = new Flight();
//         flight1.setAirlineCode("TP");
//         flight1.setDepartureCity("Lisboa");
//         flight1.setDestinationCity("Porto");
//         try {
//             Date date = format.parse("2024-06-01");
//             // flight1.setDate(date);
//         } catch (ParseException e) {
//             e.printStackTrace();
//         }
//         flight1.setDepartureHour("08:00:00");
//         flight1.setArrivalHour("09:00:00");
//         flight1.setPrice("50");
//         flight1.setState("active"); // active, canceled, completed
//         flight1.setSeatsNumber(100);
//         flight1.setSeatsTaken(new ArrayList<String>());
//         flightRepository.save(flight1);
        
//     }
// }
