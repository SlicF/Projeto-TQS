package ua.tqs.airportManager.controller;

import org.springframework.web.bind.annotation.*;
import ua.tqs.airportManager.model.Ticket;
import ua.tqs.airportManager.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
  
}
