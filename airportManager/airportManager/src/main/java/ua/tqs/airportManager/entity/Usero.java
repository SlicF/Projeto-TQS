package ua.tqs.airportManager.entity;

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
@Table(name="users")
public class Usero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    String userId;
    
    @Basic
    @Column(name = "firstName", nullable = false)
    String firstName;
    
    @Column(name = "lastName", nullable = false)
    String lastName;

    @Column(name = "username", nullable = false)
    String username;

    @Column(name = "userPassword", nullable = false)
    String password;

    @Column(name = "email")
    String email;

    @Column(name = "passportNumber")
    String passportNumber;
    
    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "country", nullable = false)
    String country;

    @Enumerated(EnumType.STRING) 
    Roles role;

    // @Column(name = "sex")
    // String sex;

    // @Column(name = "birthDate")
    // LocalDate birthDate;

    // @Column(name = "phoneNumber")
    // String phoneNumber;

    // @Column(name = "nacionality")
    // String nationality;

    // @Column(name = "postalCode", nullable = false)
    // String postalCode;

    // @Column(name = "streetAddress", nullable = false)
    // String streetAddress;
    
    // @Column(name = "cardNumber")
    // String cardNumber;

    // @Column(name = "cardPIN")
    // String cardPIN;
}
