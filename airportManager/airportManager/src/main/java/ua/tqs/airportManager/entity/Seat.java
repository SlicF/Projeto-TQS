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
@Table(name = "seats")
public class Seat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatId")
    private String seatId;

    @Column(name = "flightId", nullable = false)
    private String flightId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flightId", referencedColumnName = "flightId", insertable = false, updatable = false)
    private Flight flight;
}
