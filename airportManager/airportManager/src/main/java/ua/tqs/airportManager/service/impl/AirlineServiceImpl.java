package ua.tqs.airportManager.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Airline;
import ua.tqs.airportManager.repository.AirlineRepository;
import ua.tqs.airportManager.service.AirlineService;

@Service
@AllArgsConstructor
public class AirlineServiceImpl implements AirlineService{

    private AirlineRepository airlineRepository;
    
    @Override
    public Airline createAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public Airline getAirlineByAirlineCode(String airlineCode) {
        return airlineRepository.findByAirlineCode(airlineCode);
    }

    @Override
    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }
}
