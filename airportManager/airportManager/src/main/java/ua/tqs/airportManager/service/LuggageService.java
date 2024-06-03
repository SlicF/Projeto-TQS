package ua.tqs.airportManager.service;

import java.util.*;
import ua.tqs.airportManager.entity.Luggage;

public interface LuggageService {
    
    Luggage createLuggage(Luggage luggage);
    Luggage findByLuggageId (String luggageId);
    List<Luggage> getAllLuggages();
}
