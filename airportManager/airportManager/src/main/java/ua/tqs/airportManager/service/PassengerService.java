package ua.tqs.airportManager.service;

import java.util.*;
import ua.tqs.airportManager.entity.Passenger;

public interface PassengerService {
    
    Passenger createPassenger(Passenger passenger);
    Passenger findByPassengerId (String userId);
    List<Passenger> findByState (String state);
    List<Passenger> getAllPassengers();
}