package ua.tqs.airportManager.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ua.tqs.airportManager.entity.Passenger;
import ua.tqs.airportManager.repository.PassengerRepository;
import ua.tqs.airportManager.service.PassengerService;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService{
    
    private PassengerRepository passengerRepository;

    @Override
    public Passenger createPassenger (Passenger passenger) { 
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger findByPassengerId (String passengerId) { 
        return passengerRepository.findByPassengerId(passengerId);
    }

    @Override
    public List<Passenger> findByState (String state) {
        return passengerRepository.findByState(state);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public List<Passenger> findByUserId(String userId) {
        return passengerRepository.findByUserId(userId);
    }
}