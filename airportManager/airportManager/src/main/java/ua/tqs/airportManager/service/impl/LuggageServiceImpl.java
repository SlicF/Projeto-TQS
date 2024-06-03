package ua.tqs.airportManager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Luggage;
import ua.tqs.airportManager.repository.LuggageRepository;
import ua.tqs.airportManager.service.LuggageService;

@Service
@AllArgsConstructor
public class LuggageServiceImpl implements LuggageService{
    
    private LuggageRepository luggageRepository;

    @Override
    public Luggage createLuggage (Luggage luggage) { 
        return luggageRepository.save(luggage);
    }

    @Override
    public Optional<Luggage> findByLuggageId (String luggageId) { 
        return luggageRepository.findByLuggageId(luggageId);
    }

    @Override
    public List<Luggage> getAllLuggages() {
        return luggageRepository.findAll();
    }

    @Override
    public List<Luggage> getLuggagesByReservationId(String reservationId) {
        return luggageRepository.findByReservationId(reservationId);
    }
}
