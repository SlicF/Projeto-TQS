// package ua.tqs.airportManager.service.impl;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import ua.tqs.airportManager.entity.Seat;
// import ua.tqs.airportManager.repository.SeatRepository;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// class SeatServiceImplTest {

//     @Mock
//     private SeatRepository seatRepository;

//     @InjectMocks
//     private SeatServiceImpl seatService;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     @DisplayName("Test createSeat")
//     void testCreateSeat() {
//         Seat seat = new Seat();
//         seat.setSeatId("1");

//         when(seatRepository.save(any(Seat.class))).thenReturn(seat);

//         Seat createdSeat = seatService.createSeat(seat);

//         assertNotNull(createdSeat);
//         assertEquals("1", createdSeat.getSeatId());
//         verify(seatRepository, times(1)).save(seat);
//     }

//     @Test
//     @DisplayName("Test getSeatByFlightId")
//     void testGetSeatByFlightId() {
//         Seat seat1 = new Seat();
//         seat1.setSeatId("1");
//         seat1.setFlightId("flight1");

//         Seat seat2 = new Seat();
//         seat2.setSeatId("2");
//         seat2.setFlightId("flight1");

//         when(seatRepository.findByFlightId("flight1")).thenReturn(Arrays.asList(seat1, seat2));

//         List<Seat> seats = seatService.getSeatByFlightId("flight1");

//         assertNotNull(seats);
//         assertEquals(2, seats.size());
//         verify(seatRepository, times(1)).findByFlightId("flight1");
//     }

//     @Test
//     @DisplayName("Test getSeatBySeatId")
//     void testGetSeatBySeatId() {
//         Seat seat = new Seat();
//         seat.setSeatId("1");

//         when(seatRepository.findById("1")).thenReturn(Optional.of(seat));

//         Seat foundSeat = seatService.getSeatBySeatId("1");

//         assertNotNull(foundSeat);
//         assertEquals("1", foundSeat.getSeatId());
//         verify(seatRepository, times(1)).findById("1");


//     }

//     @Test
//     @DisplayName("Test getAllSeats")
//     void testGetAllSeats() {
//         Seat seat1 = new Seat();
//         seat1.setSeatId("1");

//         Seat seat2 = new Seat();
//         seat2.setSeatId("2");

//         when(seatRepository.findAll()).thenReturn(Arrays.asList(seat1, seat2));

//         List<Seat> seats = seatService.getAllSeats();

//         assertNotNull(seats);
//         assertEquals(2, seats.size());
//         verify(seatRepository, times(1)).findAll();
//     }
// }
