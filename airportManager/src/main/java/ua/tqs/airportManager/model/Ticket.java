package ua.tqs.airportManager.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {

    private String flightNumber;
    private String departureAirport;
    private String destinationAirport;
    private String departureTime;
    private String seatClass; 
    private int numberOfPassengers;



}   
