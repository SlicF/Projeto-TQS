package ua.tqs.airportManager.entity;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ua.tqs.airportManager.Roles;

public class ReservationTest {
    
    private static List<Reservation> reservations = new ArrayList<>();

    static LocalDate flightDate1 = LocalDate.of(2024, 5, 19);
    static LocalDate flightDate2 = LocalDate.of(2024, 7, 4);

    static ArrayList<String> seatsTaken12 = new ArrayList<>();

    static Airline airline1 = new Airline("TAP", "TAP Portugal");

    static Flight flight1 = new Flight("PTIT235", "TAP", "Portugal", "Itália", flightDate1, "09h47", "12h53", "150€", "OK", 230, seatsTaken12, airline1);
    static Flight flight2 = new Flight("PTFR873", "TAP", "Portugal", "França", flightDate2, "06h32", "08h10", "123€", "OK", 230, seatsTaken12, airline1);

    static Passenger passenger = new Passenger(1, "João", "Neves", "Masculino", LocalDate.of(2004, 2, 11), "joaoNeves", "password123", "917133984", "joaoNeves@gmail.com", "A12485", "Portuguesa", "4430-450", "Rua Santa Inácio, 148", "Porto", "Portugal", "738204761", "8364", Roles.USER);

    static Reservation reservation1 = new Reservation("7XN3G", "1", "PTIT235", "AA5", 150.0, flightDate1, "João Neves", "738204761", "11-2027", "4430-450", "Portugal", passenger, flight1);
    static Reservation reservation2 = new Reservation("N39DF", "1", "PTFR873", "AB6", 123.0, flightDate2, "João Neves", "738204761", "11-2027", "4430-450", "Portugal", passenger, flight2);

    @BeforeAll
    public static void setUp() {

        reservations.add(reservation1);
        reservations.add(reservation2);
    }

    @Test
    @DisplayName("test if reservations are correctly added to the list")
    public void testReservationsAddedToList() {
        assertEquals(2, reservations.size());
    }

    @Test
    @DisplayName("test reservation details of the reservations")
    public void testFirstReservationDetails() {
        Reservation reseservation1 = reservations.get(0);
        assertEquals("7XN3G", reseservation1.getReservationId());
        assertEquals("1", reseservation1.getPassengerId());
        assertEquals("PTIT235", reseservation1.getFlightId());
        assertEquals("AA5", reseservation1.getSeat());
        assertEquals(150.0, reseservation1.getTotalPrice());
        assertEquals(flightDate1, reseservation1.getReservationDate());
        assertEquals("João Neves", reseservation1.getNameCard());
        assertEquals("738204761", reseservation1.getNumberCard());
        assertEquals("11-2027", reseservation1.getExpirationDateCard());
        assertEquals("4430-450", reseservation1.getZipCodeCard());
        assertEquals("Portugal", reseservation1.getCountryCard());

        Reservation reservation2 = reservations.get(1);
        assertEquals("N39DF", reservation2.getReservationId());
        assertEquals("1", reservation2.getPassengerId());
        assertEquals(flightDate2, reservation2.getReservationDate());
        assertEquals("João Neves", reservation2.getNameCard());
        assertEquals("738204761", reservation2.getNumberCard());
        assertEquals("11-2027", reservation2.getExpirationDateCard());
        assertEquals("4430-450", reservation2.getZipCodeCard());
        assertEquals("Portugal", reservation2.getCountryCard());
    }

    @Test
    @DisplayName("test association between reservation and passenger")
    public void testReservationPassengerAssociation() {
        assertEquals(passenger, reservation1.getPassenger());
        assertEquals(passenger, reservation2.getPassenger());
    }

    @Test
    @DisplayName("test association between reservation and flight")
    public void testReservationFlightAssociation() {
        assertEquals(flight1, reservation1.getFlight());
        assertEquals(flight2, reservation2.getFlight());
    }
}
