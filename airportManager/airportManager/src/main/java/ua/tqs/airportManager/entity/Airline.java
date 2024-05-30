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
@Table(name = "airlines")
public class Airline {
    
    @Id
    @Column(name = "airlineCode")
    private String airlineCode;

    @Column(name = "airlineName", nullable = false)
    private String airlineName;
}
