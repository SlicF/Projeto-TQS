package ua.tqs.airportManager.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.tqs.airportManager.entity.Airline;
import ua.tqs.airportManager.repository.AirlineRepository;

@ExtendWith(MockitoExtension.class)
class AirlineServiceImplTest {

    @Mock
    private AirlineRepository airlineRepository;

    @InjectMocks
    private AirlineServiceImpl airlineService;

    private Airline airline;

    @BeforeEach
    void setUp() {
        airline = new Airline("TAP", "TAP Portugal");
    }

    @Test
    void testCreateAirline() {
        when(airlineRepository.save(any(Airline.class))).thenReturn(airline);

        Airline createdAirline = airlineService.createAirline(airline);

        assertThat(createdAirline).isNotNull();
        assertThat(createdAirline.getAirlineCode()).isEqualTo("TAP");
        assertThat(createdAirline.getAirlineName()).isEqualTo("TAP Portugal");

        verify(airlineRepository).save(any(Airline.class));
    }

    @Test
    void testGetAirlineByAirlineCode() {
        when(airlineRepository.findByAirlineCode(anyString())).thenReturn(airline);

        Airline foundAirline = airlineService.getAirlineByAirlineCode("TAP");

        assertThat(foundAirline).isNotNull();
        assertThat(foundAirline.getAirlineCode()).isEqualTo("TAP");
        assertThat(foundAirline.getAirlineName()).isEqualTo("TAP Portugal");

        verify(airlineRepository).findByAirlineCode(anyString());
    }

    @Test
    void testGetAllAirlines() {
        List<Airline> airlines = Arrays.asList(
            new Airline("TAP", "TAP Portugal"),
            new Airline("RYA", "Ryanair")
        );
        when(airlineRepository.findAll()).thenReturn(airlines);

        List<Airline> foundAirlines = airlineService.getAllAirlines();

        assertThat(foundAirlines).isNotNull();
        assertThat(foundAirlines).hasSize(2);
        assertThat(foundAirlines.get(0).getAirlineCode()).isEqualTo("TAP");
        assertThat(foundAirlines.get(0).getAirlineName()).isEqualTo("TAP Portugal");
        assertThat(foundAirlines.get(1).getAirlineCode()).isEqualTo("RYA");
        assertThat(foundAirlines.get(1).getAirlineName()).isEqualTo("Ryanair");

        verify(airlineRepository).findAll();
    }
}
