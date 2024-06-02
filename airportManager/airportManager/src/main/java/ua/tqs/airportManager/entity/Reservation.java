package ua.tqs.airportManager.entity;

import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @Temporal(TemporalType.DATE)
    @Column(name = "reservationDate", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "nameCard", nullable = false)
    private String nameCard;

    @Column(name = "numberCard", nullable = false)
    private String numberCard;

    // @Column(name = "expirationDateCard", nullable = false)
    // private String expirationDateCard;

    @Column(name = "countryCard", nullable = false)
    private String countryCard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passengerId", referencedColumnName = "passengerId", insertable = false, updatable = false)
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flightId", referencedColumnName = "flightId", insertable = false, updatable = false)
    private Flight flight;

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