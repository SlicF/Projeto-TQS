package ua.tqs.airportManager.entity;

import java.time.LocalDate;

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
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    int userId;
    
    @Basic
    @Column(name = "firstName", nullable = false)
    String firstName;
    
    @Column(name = "lastName", nullable = false)
    String lastName;

    @Column(name = "sex")
    String sex;

    @Column(name = "birthDate")
    LocalDate birthDate;

    @Column(name = "username", nullable = false)
    String username;

    @Column(name = "userPassword", nullable = false)
    String password;

    @Column(name = "phoneNumber")
    String phoneNumber;

    @Column(name = "email")
    String email;

    @Column(name = "passportNumber")
    String passportNumber;

    @Column(name = "nacionality")
    String nationality;

    @Column(name = "postalCode", nullable = false)
    String postalCode;

    @Column(name = "streetAddress", nullable = false)
    String streetAddress;
    
    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "country", nullable = false)
    String country;

    // @Column(name = "cardNumber")
    // String cardNumber;

    // @Column(name = "cardPIN")
    // String cardPIN;

    @Enumerated(EnumType.STRING) 
    Roles role;
}
