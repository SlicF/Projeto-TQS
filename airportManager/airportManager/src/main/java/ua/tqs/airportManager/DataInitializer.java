package ua.tqs.airportManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.PostConstruct;
import ua.tqs.airportManager.entity.Airline;
import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.entity.User;
import ua.tqs.airportManager.entity.Seat;
import ua.tqs.airportManager.repository.AirlineRepository;
import ua.tqs.airportManager.repository.FlightRepository;
import ua.tqs.airportManager.repository.UserRepository;

@Component
public class DataInitializer {

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    public ArrayList<Airline> airlines = new ArrayList<>();
    public Random random;
    public String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public String DIGITS = "0123456789";
    public String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    public String[] DOMAINS = {"gmail.com", "ua.pt", "up.pt", "hotmail.com"
    };

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

            userRepository.save(user);
        }
    }

    private String generateRandomCity(String country) {
         

    }
//é suposto meter um país e ir buscar uma cidade desse país, faz se um dicionário, onde a key é o pais o value é uma lista de cidades <- mete isto no gpt
    private String generateRandomCountry() {
        String[] countriesArray = {"Portugal", "Espanha", "França", "Alemanha", "Áustria", "Reino Unido", "Luxemburgo", "Bélgica"};
    }

    private String generateRandomPassportNumber() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateRandomPassportNumber'");
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
        return finalPrice + "€";
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

    // seats
    private String generateSeatId() {

        String[] seatPrefixes = {"AA", "AB", "AC"}; // adjust

        String seatPrefix = seatPrefixes[random.nextInt(seatPrefixes.length)];
        int seatNumber = random.nextInt(200) + 40;
        String seatId = seatPrefix + seatNumber;

        return seatId;
    }

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

        int length = random.nextInt(10) + 8;
        StringBuilder mail = new StringBuilder(length);
        StringBuilder letters = new StringBuilder(length - username.length());
        String domain = DOMAINS[random.nextInt(DOMAINS.length)];

        for (int i = username.length(); i < length; i++) {
            letters.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        mail.append(username).append(letters).append("@").append(domain);

        return mail.toString();
    }
}