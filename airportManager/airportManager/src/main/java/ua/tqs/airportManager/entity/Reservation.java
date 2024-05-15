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
@Table(name = "reservations")
public class Reservation {
    
    @Id
    @Column(name="reservationId", nullable = false, unique = true)
    private String reservationId;

    @Column(name="passengerId", nullable = false)
    private String passengerId;

    @Column(name="flightId", nullable = false)
    private String flightId;

    @Column(name="seat", nullable = false)
    private String seat;

    @Column(name = "totalPrice", nullable = false)
    private double totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reservationDate", nullable = false)
    private Date reservationDate;

    @Column(name = "nameCard", nullable = false)
    private String nameCard;

    @Column(name = "numberCard", nullable = false)
    private String numberCard;

    @Column(name = "expirationDateCard", nullable = false)
    private String expirationDateCard;

    // @Column(name = "cvvCard", nullable = false)
    // private String cvvCard;

    // @Column(name = "addressCard1", nullable = false)
    // private String addressCard1;

    // @Column(name = "addressCard2", nullable = true)
    // private String addressCard2;

    // @Column(name = "cityCard", nullable = false)
    // private String cityCard;

    @Column(name = "zipCodeCard", nullable = false)
    private String zipCodeCard;

    @Column(name = "countryCard", nullable = false)
    private String countryCard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passengerId", referencedColumnName = "userId", insertable = false, updatable = false)
    private Airline passenger;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flightId", referencedColumnName = "flightId", insertable = false, updatable = false)
    private Airline flight;

    @PrePersist
    public void generateReservationId() {
        this.reservationId = generateRandomId();
    }

    private String generateRandomId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder(5);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }
}