package ua.tqs.airportManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import ua.tqs.airportManager.entity.Airline;
import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.entity.Luggage;
import ua.tqs.airportManager.entity.Passenger;
import ua.tqs.airportManager.entity.Reservation;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.entity.Seat;
import ua.tqs.airportManager.repository.*;

@Component
public class DataInitializer {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
    private static final String PARIS = "Paris";
    private static final String VIENA = "Viena";

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private LuggageRepository luggageRepository;

    private List<Airline> airlines;
    private List<Flight> flights;
    private List<User> users;
    private List<Passenger> passengers;
    private List<Reservation> reservations;
    private Random random;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    private static final String[] DOMAINS = { "gmail.com", "ua.pt", "up.pt", "hotmail.com" };

    @PostConstruct
    public void init() {
        random = new Random();

        // airlines
        Airline airline1 = new Airline("TAP", "TAP Portugal");
        Airline airline2 = new Airline("RYA", "RyanAir Services");
        Airline airline3 = new Airline("EJU", "easyJet Europe");
        Airline airline4 = new Airline("QTR", "Qatar Airways");
        Airline airline5 = new Airline("LH", "Lufthansa");
        Airline airline6 = new Airline("BA", "British Airways");
        Airline airline7 = new Airline("KL", "KLM");
        Airline airline8 = new Airline("AF", "Air France");
        Airline airline9 = new Airline("IB", "Iberia");
        Airline airline10 = new Airline("TK", "Turkish Airlines");
        Airline airline11 = new Airline("AI", "Air India");
        Airline airline12 = new Airline("SQ", "Singapore Airlines");
        Airline airline13 = new Airline("MH", "Malaysia Airlines");
        Airline airline14 = new Airline("CA", "Air China");

        airlineRepository.saveAll(Arrays.asList(airline1, airline2, airline3, airline4, airline5, airline6, airline7, airline8, airline9, airline10, airline11, airline12, airline13, airline14));

        airlines = airlineRepository.findAll();

        // flights
        generateAndSaveFlights(airlines);

        Flight flight1 = new Flight("RYA9830", "RYA", VIENA, PARIS, LocalDate.of(2024, 6, 7), "07h45", "09h15", "100", "OK", 230, airline2);
        Flight flight2 = new Flight("RYA9833", "RYA", VIENA, PARIS, LocalDate.of(2024, 6, 7), "09h45", "11h15", "120", "OK", 210, airline2);
        flightRepository.saveAll(Arrays.asList(flight1, flight2));

        flights = flightRepository.findAll();

        // users
        generateAndSaveUsers();

        users = userRepository.findAll();

        // passengers
        generateAndSavePassengers();

        passengers = passengerRepository.findAll();

        // seats
        generateAndSaveSeats();

        // reservations
        generateAndSaveReservations();

        reservations = reservationRepository.findAll();
        
        // luggage
        generateAndSaveLuggage();
    }

    public void generateAndSaveFlights(List<Airline> airlines) {
        for (int i = 0; i < 50; i++) {
            Airline airline = airlines.get(random.nextInt(airlines.size()));
            String flightNumber = generateFlightNumber(airline.getAirlineCode());
            String departure = generateRandomDepartureCity();
            String destination = generateRandomDestinationCity(departure);
            LocalDate departureDate = generateRandomDepartureDate();
            String departureTime = generateRandomTime();
            String arrivalTime = generateRandomArrivalTime(departureTime);
            String price = generateRandomPrice();
            String status = random.nextBoolean() ? "OK" : "Cancelado";
            int capacity = random.nextInt(200) + 50;
            Flight flight = new Flight(flightNumber, airline.getAirlineCode(), departure, destination, departureDate, departureTime, arrivalTime, price, status, capacity, airline);
            flightRepository.save(flight);
        }
    }

    public void generateAndSaveUsers() {
        for (int i = 0; i < 10; i++) {
            String userString = generateUsername();
            String firstName = generateRandomFirstName();
            String lastName = generateRandomLastName();
            String password = ENCODER.encode(generateRandomPassword());
            String email = generateRandomEmail(userString);
            String username = email;
            String passportNumber = generateRandomPassportNumber();
            String country = generateRandomCountry();
            String city = generateRandomCity(country);
            Roles role = Roles.USER;

            User user = new User(username, firstName, lastName, password, email, passportNumber, city, country, role);
            userRepository.save(user);
        }

        List<User> adminUsers = Arrays.asList(
            new User("john.doe@example.com", "John", "Doe", ENCODER.encode(generateRandomPassword()), "john.doe@example.com", generateRandomPassportNumber(), "New York", "USA", Roles.ADMIN),
            new User("jane.smith@example.com", "Jane", "Smith", ENCODER.encode(generateRandomPassword()), "jane.smith@example.com", generateRandomPassportNumber(), "Los Angeles", "USA", Roles.ADMIN),
            new User("bob.jones@example.com", "Bob", "Jones", ENCODER.encode(generateRandomPassword()), "bob.jones@example.com", generateRandomPassportNumber(), "Chicago", "USA", Roles.ADMIN),
            new User("alice.williams@example.com", "Alice", "Williams", ENCODER.encode(generateRandomPassword()), "alice.williams@example.com", generateRandomPassportNumber(), "Houston", "USA", Roles.ADMIN),
            new User("charlie.brown@example.com", "Charlie", "Brown", ENCODER.encode(generateRandomPassword()), "charlie.brown@example.com", generateRandomPassportNumber(), "Phoenix", "USA", Roles.ADMIN)
        );

        userRepository.saveAll(adminUsers);
    }

    public void generateAndSavePassengers() {
        for (int i = 0; i < 10; i++) {
            User user = users.get(random.nextInt(users.size()));
            String passengerId = generatePassengerNumber();
            int userId = user.getUserId();
            String firstName = generateRandomFirstName();
            String lastName = generateRandomLastName();
            String state = random.nextBoolean() ? "null" : "checked-in";
            String sex = random.nextBoolean() ? "masculino" : "feminino";
            LocalDate birthDate = generatebirthDate();
            String email = user.getEmail();
            String phoneNumber = generateRandomPhoneNumber();
            String passportNumber = generateRandomPassportNumber();
            String postalCode = generateRandomPostalCode();
            String streetAddress = generateRandomStreetAddress();
            String country = generateRandomCountry();
            String city = generateRandomCity(country);
            String cardNumber = generateRandomCardNumber();
            String cardPIN = generateRandomCardPIN();

            Passenger passenger = new Passenger(passengerId, userId, firstName, lastName, state, sex, birthDate, email, phoneNumber, passportNumber, postalCode, streetAddress, city, country, cardNumber, cardPIN);
            passengerRepository.save(passenger);
        }
    }

    public void generateAndSaveSeats() {
        for (int i = 0; i < 80; i++) {
            Flight flight = flights.get(random.nextInt(flights.size()));
            String seatId = generateSeatId();
            String seatNumber = generateSeatNumber();
            String flightId = flight.getFlightId();

            Seat seat = new Seat(seatId, seatNumber, flightId, flight);
            seatRepository.save(seat);
        }
    }

    public void generateAndSaveReservations() {
        for (int i = 0; i < 7; i++) {
            Passenger passenger = passengers.get(random.nextInt(passengers.size()));
            Flight flight = flights.get(random.nextInt(flights.size()));

            String reservationNumber = generateReservationNumber();
            String passengerId = passenger.getPassengerId();
            String flightId = flight.getFlightId();
            String seat = generateSeatNumber();
            Double totalPrice = Double.parseDouble(flight.getPrice());
            LocalDate reservationDate = generateRandomReservationDate(flight.getDate());
            String nameCard = passenger.getFirstName() + " " + passenger.getLastName();
            String numberCard = passenger.getCardNumber();
            String countryCard = passenger.getCountry();

            Reservation reservation = new Reservation(reservationNumber, passengerId, flightId, seat, totalPrice, reservationDate, nameCard, numberCard, countryCard, passenger, flight);
            reservationRepository.save(reservation);
        }
    }

    public void generateAndSaveLuggage() {
        for (int i = 0; i < 5; i++) {
            Reservation reservation = reservations.get(random.nextInt(reservations.size()));
            String luggageNumber = generateLuggageNumber();
            String reservationId = reservation.getReservationId();
            String weight = generateRandomWeight();

            Luggage luggage = new Luggage(luggageNumber, reservationId, weight, reservation);
            luggageRepository.save(luggage);
        }
    }

    // helpful generate functions ------------------------------------------------------------------------------------------------------------------------------------------------------
    // flights
    private String generateFlightNumber(String airlineCode) {
        return airlineCode + random.nextInt(9999) + 1000;
    }

    private String generateRandomDepartureCity() {
        String[] citiesArray = {
            "Londres", "Paris", "Madrid", "Roma", "Berlim",
            "Amesterdão", "Barcelona", "Milão", "Frankfurt", "Viena",
            "Nova Iorque", "Los Angeles", "Miami", "Toronto", "São Paulo",
            "Rio de Janeiro", "Buenos Aires", "Tóquio", "Singapura", "Pequim",
            "Dubai", "Istambul", "Kuala Lumpur", "Delhi", "Sydney"
        };

        List<String> cities = new ArrayList<>(Arrays.asList(citiesArray));
        return cities.get(random.nextInt(cities.size()));
    }

    private String generateRandomDestinationCity(String departure) {
        String[] citiesArray = {
            "Londres", "Paris", "Madrid", "Roma", "Berlim",
            "Amesterdão", "Barcelona", "Milão", "Frankfurt", "Viena",
            "Nova Iorque", "Los Angeles", "Miami", "Toronto", "São Paulo",
            "Rio de Janeiro", "Buenos Aires", "Tóquio", "Singapura", "Pequim",
            "Dubai", "Istambul", "Kuala Lumpur", "Delhi", "Sydney"
        };

        List<String> cities = new ArrayList<>(Arrays.asList(citiesArray));
        cities.remove(departure);
        return cities.get(random.nextInt(cities.size()));
    }

    private LocalDate generateRandomDepartureDate() {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2026, 12, 31);
        long startDay = startDate.toEpochDay();
        long endDay = endDate.toEpochDay();
        long randomDay = Math.round(Math.random() * (endDay - startDay) + startDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private String generateRandomTime() {
        int hour = random.nextInt(23) + 1;
        int minute = random.nextInt(60);
        String hourStr = String.format("%02d", hour);
        String minuteStr = String.format("%02d", minute);
        return hourStr + "h" + minuteStr;
    }

    private String generateRandomArrivalTime(String departureTime) {
        int departureHour = Integer.parseInt(departureTime.substring(0, 2));
        int travelTime = random.nextInt(4) + 2;
        int arrivalHour = (departureHour + travelTime) % 24;
        int arrivalMinute = random.nextInt(60);
        String arrivalHourStr = String.format("%02d", arrivalHour);
        String arrivalMinuteStr = String.format("%02d", arrivalMinute);
        return arrivalHourStr + "h" + arrivalMinuteStr;
    }

    private String generateRandomPrice() {
        int basePrice = random.nextInt(500) + 50;
        int discount = random.nextInt(30);
        int finalPrice = Math.max(basePrice - (basePrice * discount / 100), 50);
        return Integer.toString(finalPrice);
    }

    private String generateUsername() {
        int length = random.nextInt(10) + 5;
        StringBuilder username = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            username.append(CHARACTERS.charAt(index));
        }
        return username.toString();
    }

    private String generateRandomFirstName() {
        String[] firstNames = {
            "Lucas", "Miguel", "Arthur", "Gabriel", "Heitor",
            "Alice", "Sophia", "Laura", "Valentina", "Helena",
            "Maria", "José", "Duarte", "João", "Rafael", "Marta",
            "Diogo", "Beatriz", "Leonor", "Daniel", "Henrique",
            "Bernardo", "Luísa", "Júlia", "Mariana", "Matilde", "Carlota"
        };

        return firstNames[random.nextInt(firstNames.length)];
    }

    private String generateRandomLastName() {
        String[] lastNames = {
            "Silva", "Santos", "Oliveira", "Sousa", "Lima",
            "Ferreira", "Costa", "Pereira", "Almeida", "Ribeiro",
            "Dias", "Teixeira", "Alves", "Madeira", "Gomes", "Miranda",
            "Falcão", "Gameiro", "Capucho", "Godinho", "Freixo", "Carvalho"
        };

        return lastNames[random.nextInt(lastNames.length)];
    }

    public String generateRandomPassword() {
        String allCharacters = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

        int length = random.nextInt(8) + 8;
        StringBuilder password = new StringBuilder(length);

        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        return password.toString();
    }

    public String generateRandomEmail(String username) {
        int minLength = username.length() + 1;
        int length = random.nextInt(10) + minLength;
        StringBuilder mail = new StringBuilder(length);
        StringBuilder letters = new StringBuilder(length - username.length());
        String domain = DOMAINS[random.nextInt(DOMAINS.length)];

        for (int i = 0; i < length - username.length(); i++) {
            letters.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        mail.append(username).append(letters).append("@").append(domain);
        return mail.toString();
    }

    private String generateRandomPassportNumber() {
        return UPPERCASE.charAt(random.nextInt(UPPERCASE.length())) + String.valueOf(random.nextInt(999999) + 100000);
    }

    private String generateRandomCity(String country) {
        Map<String, List<String>> countryCityMap = new HashMap<>();
        countryCityMap.put("Portugal", Arrays.asList("Lisboa", "Porto", "Faro", "Funchal"));
        countryCityMap.put("Espanha", Arrays.asList("Madrid", "Barcelona", "Vigo"));
        countryCityMap.put("França", Arrays.asList("Paris", "Marselha", "Lyon"));
        countryCityMap.put("Alemanha", Arrays.asList("Berlim", "Munique", "Hamburgo"));
        countryCityMap.put("Áustria", Arrays.asList("Viena", "Salzburgo", "Innsbruck"));
        countryCityMap.put("Reino Unido", Arrays.asList("Londres", "Manchester", "Liverpool"));
        countryCityMap.put("Luxemburgo", Arrays.asList("Luxemburgo"));
        countryCityMap.put("Bélgica", Arrays.asList("Bruxelas", "Antuérpia", "Gent"));

        List<String> cities = countryCityMap.get(country);
        return cities.get(random.nextInt(cities.size()));
    }

    private String generateRandomCountry() {
        String[] countriesArray = {"Portugal", "Espanha", "França", "Alemanha", "Áustria", "Reino Unido", "Luxemburgo", "Bélgica"};
        List<String> countries = new ArrayList<>(Arrays.asList(countriesArray));
        return countries.get(random.nextInt(countries.size()));
    }

    // passengers
    private String generatePassengerNumber() {
        StringBuilder passengerNumber = new StringBuilder(7);

        for (int i = 0; i < 7; i++) {
            passengerNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return passengerNumber.toString();
    }

    private LocalDate generatebirthDate() {
        LocalDate startDate = LocalDate.of(1920, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        long startDay = startDate.toEpochDay();
        long endDay = endDate.toEpochDay();
        long randomDay = Math.round(Math.random() * (endDay - startDay) + startDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder(7);
        phoneNumber.append(9);

        for (int i = 0; i < 8; i++) {
            phoneNumber.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        return phoneNumber.toString();
    }

    private String generateRandomPostalCode() {
        StringBuilder postalCode = new StringBuilder(8);

        for (int i = 0; i < 4; i++) {
            postalCode.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        postalCode.append("-");

        for (int i = 0; i < 3; i++) {
            postalCode.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        return postalCode.toString();
    }

    private String generateRandomStreetAddress() {
        String[] prefix = { "Rua", "Avenida", "Travessa", "Largo", "Praço" };
        String[] nomes = { " das Flores", " do Sol", " da Paz", " da Liberdade", " do Horizonte", " dos Pinheiros", " da Alegria", " do Mar", " do Rio", " da Serra", " Comandante", " Augusto" };
        String[] sufix = { "", " Velha", " Nova", " Grande", " Pequena", " do Sul", " do Norte", " do Leste", " do Oeste", " Santos", " Pereira" };
    
        StringBuilder streetAddress = new StringBuilder();
        streetAddress.append(prefix[random.nextInt(prefix.length)]);
        streetAddress.append(nomes[random.nextInt(nomes.length)]);
        streetAddress.append(sufix[random.nextInt(sufix.length)]);
        return streetAddress.toString();
    }
    
    private String generateRandomCardNumber() {
        StringBuilder cardNumber = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            cardNumber.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        return cardNumber.toString();
    }

    private String generateRandomCardPIN() {
        StringBuilder cardPIN = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            cardPIN.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        return cardPIN.toString();
    }

    // seats
    private String generateSeatId() {
        StringBuilder seatId = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            seatId.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return seatId.toString();
    }

    private String generateSeatNumber() {
        String[] seatPrefixes = {"AA", "AB", "AC"}; // adjust
        String seatPrefix = seatPrefixes[random.nextInt(seatPrefixes.length)];
        int seatNumber = random.nextInt(40) + 5;
        return seatPrefix + seatNumber;
    }

    // reservations
    private String generateReservationNumber() {
        StringBuilder reservationNumber = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            reservationNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return reservationNumber.toString();
    }

    private LocalDate generateRandomReservationDate(LocalDate flightDate) {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = flightDate.minusDays(1);
        long startDay = startDate.toEpochDay();
        long endDay = endDate.toEpochDay();
        long randomDay = Math.round(Math.random() * (endDay - startDay) + startDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    // luggage
    public String generateLuggageNumber() {
        StringBuilder luggageNumber = new StringBuilder(11);
        for (int i = 0; i < 11; i++) {
            luggageNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return luggageNumber.toString();
    }

    public String generateRandomWeight() {
        double weight = random.nextDouble() * (50 - 5) + 5;
        return String.format("%.1f", weight);
    }

}
