package ua.tqs.airportManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationProvider;
import ua.tqs.airportManager.Jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenciationFilter;
    private final AuthenticationProvider authProvider;
   
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authRequest ->
                authRequest
                    .requestMatchers("/api/flights/airlines").permitAll()
                    .requestMatchers("/api/flights/cities").permitAll()
                    .requestMatchers("/api/flights/flights").permitAll()
                    .requestMatchers("/api/flights/flights/{state}").permitAll()
                    .requestMatchers("/api/flights/flightCheckout/{flightId}").permitAll()
                    .requestMatchers("/api/flights/searchFlight").permitAll()
                    .requestMatchers("/api/passengers/passengers").permitAll()
                    .requestMatchers("/api/passengers/passengerInfo").permitAll()
                    .requestMatchers("/api/passengers/passengers/{state}").permitAll()
                    .requestMatchers("/api/passengers/createPassenger").permitAll()
                    .requestMatchers("/api/passengers/user/{userId}").permitAll()
                    .requestMatchers("/api/reservations/createReservation").permitAll()
                    .requestMatchers("/api/reservations/getAllReservations").permitAll()
                    .requestMatchers("/api/reservations/getReservation/{reservationId}").permitAll()
                    .requestMatchers("/api/reservations/getReservationsByPassenger").permitAll()
                    .requestMatchers("/api/accounts/userInfo").permitAll()
                    .requestMatchers("/api/accounts/userInfoByUsername").permitAll()
                    .requestMatchers("/api/accounts/users").permitAll()
                    .requestMatchers("/api/accounts/register").permitAll()
                    .requestMatchers("/api/accounts/login").permitAll()
                    .requestMatchers("/api/seats/seats").permitAll()
                    .requestMatchers("/api/seats/seatsByFlight").permitAll()
                    .requestMatchers("/api/seats/seatInfo").permitAll()
                    .requestMatchers("/api/seats/createSeat").permitAll()
                    .requestMatchers("/ws/**").permitAll()
                    .anyRequest().authenticated()
            )
            .sessionManagement(sessionManagement ->
                sessionManagement
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authProvider)
            .addFilterBefore(jwtAuthenciationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }
}