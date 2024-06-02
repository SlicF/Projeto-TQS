package ua.tqs.airportManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

import javax.annotation.PostConstruct;

import ua.tqs.airportManager.entity.*;
import ua.tqs.airportManager.repository.*;

@Component
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private final AirlineRepository airlineRepository;
    private final FlightRepository flightRepository;
    private final UserRepository userRepository;
    private final PassengerRepository passengerRepository;
    private final SeatRepository seatRepository;
    private final ReservationRepository reservationRepository;
    private final LuggageRepository luggageRepository;

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

    // Constants for cities
    private static final String LONDRES = "Londres";
    private static final String PARIS = "Paris";
    private static final String MADRID = "Madrid";
    private static final String ROMA = "Roma";
    private static final String BERLIM = "Berlim";
    private static final String AMESTERDAO = "Amesterdão";
    private static final String BARCELONA = "Barcelona";
    private static final String MILAO = "Milão";
    private static final String FRANKFURT = "Frankfurt";
    private static final String VIENA = "Viena";
    private static final String NOVA_IORQUE = "Nova Iorque";
    private static final String LOS_ANGELES = "Los Angeles";
    private static final String MIAMI = "Miami";
    private static final String TORONTO = "Toronto";
    private static final String SAO_PAULO = "São Paulo";
    private static final String RIO_DE_JANEIRO = "Rio de Janeiro";
    private static final String BUENOS_AIRES = "Buenos Aires";
    private static final String TOQUIO = "Tóquio";
    private static final String SINGAPURA = "Singapura";
    private static final String PEQUIM = "Pequim";
    private static final String DUBAI = "Dubai";
    private static final String ISTAMBUL = "Istambul";
    private static final String KUALA_LUMPUR = "Kuala Lumpur";
    private static final String DELHI = "Delhi";
    private static final String SYDNEY = "Sydney";

    // Constants for countries
    private static final String PORTUGAL = "Portugal";
    private static final String ESPANHA = "Espanha";
    private static final String FRANCA = "França";
    private static final String ALEMANHA = "Alemanha";
    private static final String AUSTRIA = "Áustria";
    private static final String REINO_UNIDO = "Reino Unido";
    private static final String LUXEMBURGO = "Luxemburgo";
    private static final String BELGICA = "Bélgica";

    @Autowired
    public DataInitializer(AirlineRepository airlineRepository, FlightRepository flightRepository, UserRepository userRepository, 
                           PassengerRepository passengerRepository, SeatRepository seatRepository, ReservationRepository reservationRepository,
                           LuggageRepository luggageRepository) {
        this.airlineRepository = airlineRepository;
        this.flightRepository = flightRepository;
        this.userRepository = userRepository;
        this.passengerRepository = passengerRepository;
        this.seatRepository = seatRepository;
        this.reservationRepository = reservationRepository;
        this.luggageRepository = luggageRepository;
    }

    @PostConstruct
    public void init() {
        random = new Random();

        // airlines
        List<Airline> initialAirlines = Arrays.asList(
            new Airline("TAP", "TAP Portugal"),
            new Airline("RYA", "RyanAir Services"),
            new Airline("EJU", "easyJet Europe"),
            new Airline("QTR", "Qatar Airways"),
            new Airline("LH", "Lufthansa"),
            new Airline("BA", "British Airways"),
            new Airline("KL", "KLM"),
            new Airline("AF", "Air France"),
            new Airline("IB", "Iberia"),
            new Airline("TK", "Turkish Airlines"),
            new Airline("AI", "Air India"),
            new Airline("SQ", "Singapore Airlines"),
            new Airline("MH", "Malaysia Airlines"),
            new Airline("CA", "Air China")
        );

        airlineRepository.saveAll(initialAirlines);
        airlines = airlineRepository.findAll();

        // flights
        generateAndSaveFlights(airlines);
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

    public List<Airline> getAirlines() {
        return new ArrayList<>(airlines); // Return a copy to avoid modification
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights); // Return a copy to avoid modification
    }

    public List<User> getUsers() {
        return new ArrayList<>(users); // Return a copy to avoid modification
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers); // Return a copy to avoid modification
    }

    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations); // Return a copy to avoid modification
    }

    private void generateAndSaveFlights(List<Airline> airlines) {
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
            logger.info("Saving flight: {}", flight);
            flightRepository.save(flight);
        }
    }

    private void generateAndSaveUsers() {
        for (int i = 0; i < 20; i++) {
            String username = generateUsername();
            String userId = generateUserNumber(username);
            String firstName = generateRandomFirstName();
            String lastName = generateRandomLastName();
            String password = generateRandomPassword();
            String email = generateRandomEmail(username);
            String passportNumber = generateRandomPassportNumber();
            String country = generateRandomCountry();
            String city = generateRandomCity(country);
            Roles role = random.nextBoolean() ? Roles.ADMIN : Roles.USER;

            User user = new User(userId, username, firstName, lastName, password, email, passportNumber, city, country, role);
            logger.info("Saving user: {}", user);
            userRepository.save(user);
        }
    }

    private void generateAndSavePassengers() {
        for (int i = 0; i < 10; i++) {
            User user = users.get(random.nextInt(users.size()));
            String passengerId = generatePassengerNumber();
            String userId = user.getUserId();
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

            Passenger passenger = new Passenger(passengerId, userId, firstName, lastName, state, sex, birthDate, email, phoneNumber, passportNumber, postalCode, streetAddress, city, country, cardNumber, cardPIN, user);
            logger.info("Saving passenger: {}", passenger);
            passengerRepository.save(passenger);
        }
    }

    private void generateAndSaveSeats() {
        for (int i = 0; i < 80; i++) {
            Flight flight = flights.get(random.nextInt(flights.size()));
            String seatId = generateSeatId();
            String seatNumber = generateSeatNumber();
            String flightId = flight.getFlightId();

            Seat seat = new Seat(seatId, seatNumber, flightId, flight);
            logger.info("Saving seat: {}", seat);
            seatRepository.save(seat);
        }
    }

    private void generateAndSaveReservations() {
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
            String expirationDateCard = generateRandomExpirationDateCard();
            String countryCard = passenger.getCountry();

            Reservation reservation = new Reservation(reservationNumber, passengerId, flightId, seat, totalPrice, reservationDate, nameCard, numberCard, expirationDateCard, countryCard, passenger, flight);
            logger.info("Saving reservation: {}", reservation);
            reservationRepository.save(reservation);
        }
    }

    private void generateAndSaveLuggage() {
        for (int i = 0; i < 5; i++) {
            Reservation reservation = reservations.get(random.nextInt(reservations.size()));
            String luggageNumber = generateLuggageNumber();
            String reservationId = reservation.getReservationId();
            String weight = generateRandomWeight();

            Luggage luggage = new Luggage(luggageNumber, reservationId, weight, reservation);
            logger.info("Saving luggage: {}", luggage);
            luggageRepository.save(luggage);
        }
    }

    // Helper methods for generating random data
    private String generateFlightNumber(String airlineCode) {
        return airlineCode + (random.nextInt(9000) + 1000);
    }

    private String generateRandomDepartureCity() {
        String[] citiesArray = {
            LONDRES, PARIS, MADRID, ROMA, BERLIM,
            AMESTERDAO, BARCELONA, MILAO, FRANKFURT, VIENA,
            NOVA_IORQUE, LOS_ANGELES, MIAMI, TORONTO, SAO_PAULO,
            RIO_DE_JANEIRO, BUENOS_AIRES, TOQUIO, SINGAPURA, PEQUIM,
            DUBAI, ISTAMBUL, KUALA_LUMPUR, DELHI, SYDNEY
        };

        return citiesArray[random.nextInt(citiesArray.length)];
    }

    private String generateRandomDestinationCity(String departure) {
        String[] citiesArray = {
            LONDRES, PARIS, MADRID, ROMA, BERLIM,
            AMESTERDAO, BARCELONA, MILAO, FRANKFURT, VIENA,
            NOVA_IORQUE, LOS_ANGELES, MIAMI, TORONTO, SAO_PAULO,
            RIO_DE_JANEIRO, BUENOS_AIRES, TOQUIO, SINGAPURA, PEQUIM,
            DUBAI, ISTAMBUL, KUALA_LUMPUR, DELHI, SYDNEY
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
        long randomDay = startDay + random.nextLong(endDay - startDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private String generateRandomTime() {
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        return String.format("%02dh%02d", hour, minute);
    }

    private String generateRandomArrivalTime(String departureTime) {
        int departureHour = Integer.parseInt(departureTime.substring(0, 2));
        int travelTime = random.nextInt(4) + 2;
        int arrivalHour = (departureHour + travelTime) % 24;
        int arrivalMinute = random.nextInt(60);
        return String.format("%02dh%02d", arrivalHour, arrivalMinute);
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
            username.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return username.toString();
    }

    private String generateUserNumber(String username) {
        return username.charAt(0) + String.valueOf(random.nextInt(9000) + 1000) + username.charAt(1);
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

    private String generateRandomPassword() {
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

    private String generateRandomEmail(String username) {
        int minLength = username.length() + 1;
        int length = random.nextInt(10) + minLength;
        StringBuilder letters = new StringBuilder(length - username.length());
        String domain = DOMAINS[random.nextInt(DOMAINS.length)];

        for (int i = 0; i < length - username.length(); i++) {
            letters.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return username + letters.toString() + "@" + domain;
    }

    private String generateRandomPassportNumber() {
        return UPPERCASE.charAt(random.nextInt(UPPERCASE.length())) + String.valueOf(random.nextInt(900000) + 100000);
    }

    private String generateRandomCity(String country) {
        Map<String, List<String>> countryCityMap = new HashMap<>();
        countryCityMap.put(PORTUGAL, Arrays.asList("Lisboa", "Porto", "Faro", "Funchal"));
        countryCityMap.put(ESPANHA, Arrays.asList(MADRID, BARCELONA, "Vigo"));
        countryCityMap.put(FRANCA, Arrays.asList(PARIS, "Marselha", "Lyon"));
        countryCityMap.put(ALEMANHA, Arrays.asList(BERLIM, "Munique", "Hamburgo"));
        countryCityMap.put(AUSTRIA, Arrays.asList(VIENA, "Salzburgo", "Innsbruck"));
        countryCityMap.put(REINO_UNIDO, Arrays.asList(LONDRES, "Manchester", "Liverpool"));
        countryCityMap.put(LUXEMBURGO, Arrays.asList(LUXEMBURGO));
        countryCityMap.put(BELGICA, Arrays.asList("Bruxelas", "Antuérpia", "Gent"));

        List<String> cities = countryCityMap.get(country);
        return cities.get(random.nextInt(cities.size()));
    }

    private String generateRandomCountry() {
        String[] countriesArray = {PORTUGAL, ESPANHA, FRANCA, ALEMANHA, AUSTRIA, REINO_UNIDO, LUXEMBURGO, BELGICA};
        return countriesArray[random.nextInt(countriesArray.length)];
    }

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
        long randomDay = startDay + random.nextLong(endDay - startDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder(9);
        phoneNumber.append(9);
        for (int i = 1; i < 9; i++) {
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
        String[] names = { " das Flores", " do Sol", " da Paz", " da Liberdade", " do Horizonte", " dos Pinheiros", " da Alegria", " do Mar", " do Rio", " da Serra", " Comandante", " Augusto" };
        String[] suffix = { "", " Velha", " Nova", " Grande", " Pequena", " do Sul", " do Norte", " do Leste", " do Oeste", " Santos", " Pereira" };

        return prefix[random.nextInt(prefix.length)] + names[random.nextInt(names.length)] + suffix[random.nextInt(suffix.length)];
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

    private String generateSeatId() {
        StringBuilder seatId = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            seatId.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return seatId.toString();
    }

    private String generateSeatNumber() {
        String[] seatPrefixes = {"AA", "AB", "AC"}; 
        String seatPrefix = seatPrefixes[random.nextInt(seatPrefixes.length)];
        int seatNumber = random.nextInt(200) + 40;
        return seatPrefix + seatNumber;
    }

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
        long randomDay = startDay + random.nextLong(endDay - startDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private String generateRandomExpirationDateCard() {
        int year = random.nextInt(6) + 2024;
        int month = random.nextInt(12) + 1;
        return String.format("%04d-%02d", year, month);
    }

    private String generateLuggageNumber() {
        StringBuilder luggageNumber = new StringBuilder(11);
        for (int i = 0; i < 11; i++) {
            luggageNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return luggageNumber.toString();
    }

    private String generateRandomWeight() {
        double weight = random.nextDouble() * 45 + 5;
        return String.format("%.1f", weight);
    }
}
