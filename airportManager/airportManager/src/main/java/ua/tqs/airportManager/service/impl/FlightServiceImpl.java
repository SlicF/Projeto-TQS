package ua.tqs.airportManager.service.impl;

import java.time.LocalDate;
import java.util.*;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Flight;
import ua.tqs.airportManager.repository.FlightRepository;
import ua.tqs.airportManager.service.FlightService;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService{
   
    private FlightRepository flightRepository;

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight getFlightByFlightId(String flightId) {
        return flightRepository.findByFlightId(flightId);
    }

    @Override
    public List<Flight> getFlightsByState(String state) {
        return flightRepository.findByState(state);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> findByDepartureCityAndArrivalCityAndDate(String departureCity, String arrivalCity, LocalDate flightDate) {
        return flightRepository.findByDepartureCityAndArrivalCityAndDate(departureCity, arrivalCity, flightDate);
    }

    public List<String> getAllCities() {
        List<String> departureCities = flightRepository.findAllDepartureCities();
        List<String> arrivalCities = flightRepository.findAllArrivalCities();
        
        // Combine as listas de cidades de partida e chegada e remova duplicatas
        Set<String> uniqueCities = new HashSet<>();
        uniqueCities.addAll(departureCities);
        uniqueCities.addAll(arrivalCities);
        
        return new ArrayList<>(uniqueCities);
    }
}