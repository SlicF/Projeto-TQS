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
@Table(name = "accounts")
public class User {
    
    @Id
    @Column(name="userId", nullable = false, unique = true)
    private String userId;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Basic
    @Column(name = "firstName", nullable = false)
    String firstName;
    
    @Column(name = "lastName", nullable = false)
    String lastName;

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
}