package ua.tqs.airportManager;

import org.springframework.beans.factory.annotation.Autowired;
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

    public ArrayList<Airline> airlines = new ArrayList<>();
    public ArrayList<Flight> flights = new ArrayList<>();
    public ArrayList<User> users = new ArrayList<>();
    public ArrayList<Passenger> passengers = new ArrayList<>();
    public List<Reservation> reservations;
    public Random random;
    public String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public String DIGITS = "0123456789";
    public String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    public String[] DOMAINS = { "gmail.com", "ua.pt", "up.pt", "hotmail.com" };

    @PostConstruct
    public void init() {
        
        // airlines
        Airline airline1 = new Airline("TAP", "TAP Portugal");
        airlines.add(airline1);
        Airline airline2 = new Airline("RYA", "Ryan Air Services");
        airlines.add(airline2);
        Airline airline3 = new Airline("EJU", "easyJet Europe");
        airlines.add(airline3);
        Airline airline4 = new Airline("QTR", "Qatar Airways");
        airlines.add(airline4);
        Airline airline5 = new Airline("LH", "Lufthansa");
        airlines.add(airline5);
        Airline airline6 = new Airline("BA", "British Airways");
        airlines.add(airline6);
        Airline airline7 = new Airline("KL", "KLM");
        airlines.add(airline7);
        Airline airline8 = new Airline("AF", "Air France");
        airlines.add(airline8);
        Airline airline9 = new Airline("IB", "Iberia");
        airlines.add(airline9);
        Airline airline10 = new Airline("TK", "Turkish Airlines");
        airlines.add(airline10);
        Airline airline11 = new Airline("AI", "Air India");
        airlines.add(airline11);
        Airline airline12 = new Airline("SQ", "Singapore Airlines");
        airlines.add(airline12);
        Airline airline13 = new Airline("MH", "Malaysia Airlines");
        airlines.add(airline13);
        Airline airline14 = new Airline("CA", "Air China");
        airlines.add(airline14);

            airlineRepository.save(airline1);
            airlineRepository.save(airline2);
            airlineRepository.save(airline3);
            airlineRepository.save(airline4);
            airlineRepository.save(airline5);
            airlineRepository.save(airline6);
            airlineRepository.save(airline7);
            airlineRepository.save(airline8);
            airlineRepository.save(airline9);
            airlineRepository.save(airline10);
            airlineRepository.save(airline11);
            airlineRepository.save(airline12);
            airlineRepository.save(airline13);
            airlineRepository.save(airline14);

        // flights
        random = new Random();
        
        generateAndSaveFlights(airlines);

        // users
        generateAndSaveUsers();

        // passengers
        generateAndSavePassengers();

        // seats
        generateAndSaveSeats();

        // reservations
        generateAndSaveReservations();

        reservations = reservationRepository.findAll();
        
        // luggage
        generateAndSaveLuggage();
    }

    public void generateAndSaveFlights(ArrayList<Airline> airlines) {

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
            // List<Seat> seatsTaken = generateRandomSeats(capacity);

            Flight flight = new Flight(flightNumber, airline.getAirlineCode(), departure, destination, departureDate, departureTime, arrivalTime, price, status, capacity, airline);
            System.out.println(flight);

            flights.add(flight);
            flightRepository.save(flight);
        }
    }

    public void generateAndSaveUsers() {

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
            System.out.println(user);

            users.add(user);
            userRepository.save(user);
        }
    }

    public void generateAndSavePassengers() {

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
            System.out.println(passenger);

            passengers.add(passenger);
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
            System.out.println(seat);

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
            String expirationDateCard = generateRandomExpirationDateCard();
            String countryCard = passenger.getCountry();

            Reservation reservation = new Reservation(reservationNumber, passengerId, flightId, seat, totalPrice, reservationDate, nameCard, numberCard, expirationDateCard, countryCard, passenger, flight);
            System.out.println(reservation);

            // reservations.add(reservation);
            reservationRepository.save(reservation);
        }
    }

    public void generateAndSaveLuggage() {

        for (int i = 0; i < 5; i++) {

            System.out.println("reservations: " + reservations);
            Reservation reservation = reservations.get(random.nextInt(reservations.size()));
            System.out.println("olaaaaaaaaaaa: " + reservations.size());
            
            String luggageNumber = generateLuggageNumber();
            String reservationId = reservation.getReservationId();
            String weight = generateRandomWeight();

            Luggage luggage = new Luggage(luggageNumber, reservationId, weight, reservation);
            System.out.println(luggage);

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
            
        return cities.get(this.random.nextInt(cities.size()));
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

        return cities.get(this.random.nextInt(cities.size()));
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

        int hour = this.random.nextInt(23) + 1;
        int minute = this.random.nextInt(60);
        String hourStr = String.format("%02d", hour);
        String minuteStr = String.format("%02d", minute);
        return hourStr + "h" + minuteStr;
    }

    private String generateRandomArrivalTime(String departureTime) {

        int departureHour = Integer.parseInt(departureTime.substring(0, 2));
        int travelTime = this.random.nextInt(4) + 2;
        int arrivalHour = (departureHour + travelTime) % 24;
        int arrivalMinute = this.random.nextInt(60);
        String arrivalHourStr = String.format("%02d", arrivalHour);
        String arrivalMinuteStr = String.format("%02d", arrivalMinute);
        return arrivalHourStr + "h" + arrivalMinuteStr;
    }

    private String generateRandomPrice() {

        Random random = new Random();
        int basePrice = random.nextInt(500) + 50;
        int discount = random.nextInt(30);
        int finalPrice = Math.max(basePrice - (basePrice * discount / 100), 50);
        return Integer.toString(finalPrice);
    }

    // private List<Seat> generateRandomSeats(int capacity) {
    //     Random random = new Random();
    //     int numSeatsTaken = random.nextInt(capacity / 3) + 1;
    //     List<Seat> seatsTaken = new ArrayList<>();
    
    //     // generate random seat ids
    //     for (int i = 0; i < numSeatsTaken; i++) {
    //         String seatId = generateSeatId();
    //         Seat seat = new Seat(seatId);
    //         seatsTaken.add(seat)    ;
    //     }
        
    //     Set<String> existingSeatIds = new HashSet<>(); // set to store unique seat ids

    //     for (int i = 0; i < numSeatsTaken; i++) {
    //         String seatId;

    //         do {
    //             seatId = generateSeatId();
    //         } while (existingSeatIds.contains(seatId));

    //         existingSeatIds.add(seatId); // Add to set if unique

    //         Seat seat = new Seat(seatId);
    //         seatsTaken.add(seat);
    //     }

    //     return seatsTaken;
    // }

    // users
    private String generateUserNumber(String username) {
        String[] letters = username.split("");
        return letters[0] + random.nextInt(9999) + 1000 + letters[1];
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

        String[] FIRST_NAMES = {
            "Lucas", "Miguel", "Arthur", "Gabriel", "Heitor",
            "Alice", "Sophia", "Laura", "Valentina", "Helena",
            "Maria", "José", "Duarte", "João", "Rafael", "Marta",
            "Diogo", "Beatriz", "Leonor", "Daniel", "Henrique",
            "Bernardo", "Luísa", "Júlia", "Mariana", "Matilde", "Carlota"
        };
    
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

        return firstName;
    }

    private String generateRandomLastName() {

        String[] LAST_NAMES = {
            "Silva", "Santos", "Oliveira", "Sousa", "Lima",
            "Ferreira", "Costa", "Pereira", "Almeida", "Ribeiro",
            "Dias", "Teixeira", "Alves", "Madeira", "Gomes", "Miranda",
            "Falcão", "Gameiro", "Capucho", "Godinho", "Freixo", "Carvalho"
        };
    
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];

        return lastName;
    }

    public String generateRandomPassword() {
        String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

        int length = random.nextInt(8) + 8;
        StringBuilder password = new StringBuilder(length);

        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        return password.toString();
    }

    public String generateRandomEmail(String username) {

        int minLenght = username.length() + 1;
        int length = random.nextInt(10) + minLenght;
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
        
        Character letter = UPPERCASE.charAt(random.nextInt(UPPERCASE.length()));

        return letter + random.nextInt(999999) + 100000 + "";
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
        return cities.get(this.random.nextInt(cities.size()));
    }

    private String generateRandomCountry() {
        String[] countriesArray = {"Portugal", "Espanha", "França", "Alemanha", "Áustria", "Reino Unido", "Luxemburgo", "Bélgica"};
        List<String> countries = new ArrayList<>(Arrays.asList(countriesArray));
        return countries.get(this.random.nextInt(countries.size()));
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

        String[] PREFIX = { "Rua", "Avenida", "Travessa", "Largo", "Praço" };
        String[] NOMES = { " das Flores", " do Sol", " da Paz", " da Liberdade", " do Horizonte", " dos Pinheiros", " da Alegria", " do Mar", " do Rio", " da Serra", " Comandante", " Augusto" };
        String[] SUFIX = { "", " Velha", " Nova", " Grande", " Pequena", " do Sul", " do Norte", " do Leste", " do Oeste", " Santos", " Pereira" };

        StringBuilder streetAddress = new StringBuilder();

        streetAddress.append(PREFIX[random.nextInt(PREFIX.length)]);
        streetAddress.append(NOMES[random.nextInt(NOMES.length)]);
        streetAddress.append(SUFIX[random.nextInt(SUFIX.length)]);

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
        int seatNumber = random.nextInt(200) + 40;
        String seatId = seatPrefix + seatNumber;

        return seatId;
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
        LocalDate endDate = LocalDate.of(flightDate.getYear(), flightDate.getMonth(), flightDate.getDayOfMonth() - 1);
        long startDay = startDate.toEpochDay();
        long endDay = endDate.toEpochDay();
        long randomDay = Math.round(Math.random() * (endDay - startDay) + startDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public String generateRandomExpirationDateCard() {

        StringBuilder expirationDateCard = new StringBuilder();
        String year = Integer.toString(random.nextInt(6) + 2024);
        String month = Integer.toString(random.nextInt(12) + 1);

        expirationDateCard.append(year).append(" - ").append(month);

        return expirationDateCard.toString();
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

        Double weight = random.nextDouble(45) + 5;
        
        return Double.toString(Math.round(weight * 10) / 10.0);
    }

}