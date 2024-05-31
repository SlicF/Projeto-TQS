package ua.tqs.airportManager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ua.tqs.airportManager.entity.Airline;
import ua.tqs.airportManager.entity.Flight;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class FlightRepositoryTests {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Test
    public void testFindByFlightId() {
        Flight flight;
        Airline airline = new Airline("EX", "Example Air");

        airlineRepository.save(airline);

        flight = new Flight("ABC123", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100", "Scheduled",
                100, airline);

        flightRepository.save(flight);

        Flight foundFlight = flightRepository.findByFlightId("ABC123");

        assertNotNull(foundFlight);
        assertEquals(flight.getFlightId(), foundFlight.getFlightId());
    }

    @Test
    public void testFindByState() {
        Airline airline = new Airline("EX", "Example Air");
        airlineRepository.save(airline);

        Flight flight1 = new Flight("ABC123", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100",
                "Scheduled", 100, airline);
        flight1.setState("Scheduled");
        flightRepository.save(flight1);

        Flight flight2 = new Flight("ABC321", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100",
                "Delayed", 100, airline);
        flight2.setState("Delayed");
        flightRepository.save(flight2);

        List<Flight> foundFlights = flightRepository.findByState("Scheduled");

        assertEquals(1, foundFlights.size());
        assertEquals(flight1.getState(), foundFlights.get(0).getState());
    }

    @Test
    public void testFindByDepartureCityAndArrivalCityAndDate() {
        Airline airline = new Airline("EX", "Example Air");
        airlineRepository.save(airline);

        Flight flight1 = new Flight("ABC123", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100",
                "Scheduled", 100, airline);
        flight1.setState("Scheduled");
        flight1.setDepartureCity("City1");
        flight1.setArrivalCity("City2");
        flight1.setDate(LocalDate.now());
        flightRepository.save(flight1);

        Flight flight2 = new Flight("ABC321", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100",
                "Delayed", 100, airline);
        flight2.setDepartureCity("City1");
        flight2.setArrivalCity("City3");
        flight2.setDate(LocalDate.now());
        flightRepository.save(flight2);

        List<Flight> foundFlights = flightRepository.findByDepartureCityAndArrivalCityAndDate("City1", "City2",
                LocalDate.now());

        assertEquals(1, foundFlights.size());
        assertEquals(flight1.getDepartureCity(), foundFlights.get(0).getDepartureCity());
        assertEquals(flight1.getArrivalCity(), foundFlights.get(0).getArrivalCity());
        assertEquals(flight1.getDate(), foundFlights.get(0).getDate());
    }

    @Test
    public void testFindAllDepartureCities() {
        Airline airline = new Airline("EX", "Example Air");
        airlineRepository.save(airline);

        Flight flight1 = new Flight("ABC123", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100",
        "Scheduled", 100, airline);
        flight1.setDepartureCity("City1");
        flightRepository.save(flight1);

        Flight flight2 = new Flight("ABC321", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100", "Scheduled",
                100, airline);
        flight2.setDepartureCity("City2");
        flightRepository.save(flight2);

        List<String> departureCities = flightRepository.findAllDepartureCities();

        assertEquals(2, departureCities.size());
        assertEquals(flight1.getDepartureCity(), departureCities.get(0));
        assertEquals(flight2.getDepartureCity(), departureCities.get(1));
    }

    @Test
    public void testFindAllArrivalCities() {
        Airline airline = new Airline("EX", "Example Air");
        airlineRepository.save(airline);

        Flight flight1 = new Flight("ABC123", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100",
                "Scheduled", 100, airline);
        flight1.setArrivalCity("City1");
        flightRepository.save(flight1);

        Flight flight2 = new Flight("ABC321", "EX", "City1", "City2", LocalDate.now(), "12:00", "14:00", "100",
                "Scheduled", 100, airline);
        flight2.setArrivalCity("City2");
        flightRepository.save(flight2);

        List<String> arrivalCities = flightRepository.findAllArrivalCities();

        assertEquals(2, arrivalCities.size());
        assertEquals(flight1.getArrivalCity(), arrivalCities.get(0));
        assertEquals(flight2.getArrivalCity(), arrivalCities.get(1));
    }
}