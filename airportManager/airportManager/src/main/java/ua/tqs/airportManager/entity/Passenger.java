package ua.tqs.airportManager.entity;

import java.time.LocalDate;
import java.util.Random;

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
@Table(name = "passengers")
public class Passenger {

    @Id
    @Column(name="passengerId", nullable = false, unique = true)
    private String passengerId;

    @Column(name = "userId")
    private int userId;

    @Column(name="firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name="state", nullable = false)
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

    @PrePersist
    public void generateReservationId() {
        this.passengerId = generateRandomId();
    }

    private String generateRandomId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(7);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }
}