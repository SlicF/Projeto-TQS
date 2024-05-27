package ua.tqs.airportManager.entity;

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
@Table(name = "seats") // para guardar os lugares ocupados
public class Seat {
    
    @Id
    @Column(name="seatId", nullable = false, unique = true)
    private String seatId;

    @Column(name="seatNumber", nullable = false)
    private String seatNumber;

    @Column(name="flightId", nullable = false)
    private String flightId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flightId", referencedColumnName = "flightId", insertable = false, updatable = false)
    private Flight flight;
}
