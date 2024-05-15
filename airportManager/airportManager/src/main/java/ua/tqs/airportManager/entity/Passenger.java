package ua.tqs.airportManager.entity;

// import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.tqs.airportManager.Roles;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Passenger {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    int userId;
    @Basic
    @Column(name = "firstName", nullable = false)
    String firstName;
    
    @Column(name = "lastName", nullable = false)
    String lastName;

    @Column(name = "sex", nullable = false)
    String sex;

    @Column(name = "birthDate", nullable = false)
    Date birthDate;

    @Column(name = "username", nullable = false)
    String username;

    @Column(name = "userPassword", nullable = false)
    String password;

    @Column(name = "phoneNumber", nullable = false)
    String phoneNumber;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "passportNumber", nullable = false)
    String passportNumber;

    @Column(name = "nacionality", nullable = false)
    String nationality;

    @Column(name = "postalCode", nullable = false)
    String postalCode;

    @Column(name = "streetAddress", nullable = false)
    String streetAddress;
    
    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "country", nullable = false)
    String country;

    @Column(name = "cardNumber", nullable = false)
    String cardNumber;

    @Column(name = "cardPIN", nullable = false)
    String cardPIN;

    @Enumerated(EnumType.STRING) 
    Roles role;
}
