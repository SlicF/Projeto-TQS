package ua.tqs.airportManager.entity;

import java.time.LocalDate;

// import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.tqs.airportManager.Roles;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="passengers")
public class Passenger {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passengerId")
    private int passengerId;

    @Column(name = "userId")
    private int userId;
    
    @Column(name = "firstName", nullable = false)
    private String firstName;
    
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "passportNumber", nullable = false)
    private String passportNumber;

    @Column(name = "postalCode", nullable = false)
    private String postalCode;

    @Column(name = "streetAddress", nullable = false)
    private String streetAddress;
    
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "cardNumber", nullable = false)
    private String cardNumber;

    @Column(name = "cardPIN", nullable = false)
    private String cardPIN;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    private User user;
}
