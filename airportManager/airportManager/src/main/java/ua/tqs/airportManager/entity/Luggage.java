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
@Table(name = "luggage")
public class Luggage {
    
    @Id
    @Column(name = "luggageId")
    private String luggageId;

    @Column(name = "reservationId", nullable = false)
    private String reservationId;

    @Column(name = "weight", nullable = false)
    private String weight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reservationId", referencedColumnName = "reservationId", insertable = false, updatable = false)
    private Reservation reservation;
}
