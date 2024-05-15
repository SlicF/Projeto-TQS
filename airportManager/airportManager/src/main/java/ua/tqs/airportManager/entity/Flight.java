package ua.tqs.airportManager.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flights")
public class Flight {
    
    @Id
    @Column(name = "flightId")
    private String flightId;

    @Column(name = "airlineCode", nullable = false)
    private String airlineCode;

    @Column(name="departureCity", nullable = false)
    private String departureCity;

    @Column(name="arrivalCity", nullable = false)
    private String destinationCity;

    @Column(name="flightDate", nullable = false)
    private Date date;

    @Column(name="departureHour", nullable = false)
    private String departureHour;

    @Column(name="arrivalHour", nullable = false)
    private String arrivalHour;

    @Column(name="price", nullable = false)
    private String price;

    @Column(name="state", nullable = false)
    private String state;
    
    @Column(name="seatsNumber", nullable = false)
    private Integer seatsNumber;

    @Column(name="seatsTaken")
    private ArrayList<String> seatsTaken;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airlineCode", referencedColumnName = "airlineCode", insertable = false, updatable = false)
    private Airline airline;
}