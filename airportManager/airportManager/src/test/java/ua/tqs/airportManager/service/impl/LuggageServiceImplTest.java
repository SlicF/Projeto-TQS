package ua.tqs.airportManager.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.tqs.airportManager.entity.Luggage;
import ua.tqs.airportManager.repository.LuggageRepository;

class LuggageServiceImplTest {

    @Mock
    private LuggageRepository luggageRepository;

    @InjectMocks
    private LuggageServiceImpl luggageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLuggage() {
        Luggage luggage = new Luggage();
        luggage.setLuggageId("L123");

        when(luggageRepository.save(any(Luggage.class))).thenReturn(luggage);

        Luggage createdLuggage = luggageService.createLuggage(luggage);

        assertNotNull(createdLuggage);
        assertEquals("L123", createdLuggage.getLuggageId());
        verify(luggageRepository, times(1)).save(any(Luggage.class));
    }


    @Test
    void testGetAllLuggages() {
        Luggage luggage1 = new Luggage();
        luggage1.setLuggageId("L123");

        Luggage luggage2 = new Luggage();
        luggage2.setLuggageId("L124");

        List<Luggage> luggages = Arrays.asList(luggage1, luggage2);

        when(luggageRepository.findAll()).thenReturn(luggages);

        List<Luggage> foundLuggages = luggageService.getAllLuggages();

        assertNotNull(foundLuggages);
        assertEquals(2, foundLuggages.size());
        verify(luggageRepository, times(1)).findAll();
    }

    @Test
    void testGetLuggagesByReservationId() {
        Luggage luggage1 = new Luggage();
        luggage1.setLuggageId("L123");

        Luggage luggage2 = new Luggage();
        luggage2.setLuggageId("L124");

        List<Luggage> luggages = Arrays.asList(luggage1, luggage2);

        when(luggageRepository.findByReservationId("R123")).thenReturn(luggages);

        List<Luggage> foundLuggages = luggageService.getLuggagesByReservationId("R123");

        assertNotNull(foundLuggages);
        assertEquals(2, foundLuggages.size());
        verify(luggageRepository, times(1)).findByReservationId("R123");
    }
}