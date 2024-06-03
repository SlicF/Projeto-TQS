package ua.tqs.airportManager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String passportNumber;
    private String city;
    private String country;
}
