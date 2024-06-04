package ua.tqs.airportManager.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import ua.tqs.airportManager.Roles;

class UseroTest {

    @Test
    void testNoArgsConstructor() {
        Usero user = new Usero();
        assertThat(user).isNotNull();
    }

    @Test
    void testAllArgsConstructor() {
        Usero user = new Usero("1", "John", "Doe", "john.doe", "password", "john.doe@example.com", "A1234567", "New York", "USA", Roles.USER);
        assertThat(user.getUserId()).isEqualTo("1");
        assertThat(user.getFirstName()).isEqualTo("John");
        assertThat(user.getLastName()).isEqualTo("Doe");
        assertThat(user.getUsername()).isEqualTo("john.doe");
        assertThat(user.getPassword()).isEqualTo("password");
        assertThat(user.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(user.getPassportNumber()).isEqualTo("A1234567");
        assertThat(user.getCity()).isEqualTo("New York");
        assertThat(user.getCountry()).isEqualTo("USA");
        assertThat(user.getRole()).isEqualTo(Roles.USER);
    }

    @Test
    void testSettersAndGetters() {
        Usero user = new Usero();
        user.setUserId("1");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUsername("john.doe");
        user.setPassword("password");
        user.setEmail("john.doe@example.com");
        user.setPassportNumber("A1234567");
        user.setCity("New York");
        user.setCountry("USA");
        user.setRole(Roles.USER);

        assertThat(user.getUserId()).isEqualTo("1");
        assertThat(user.getFirstName()).isEqualTo("John");
        assertThat(user.getLastName()).isEqualTo("Doe");
        assertThat(user.getUsername()).isEqualTo("john.doe");
        assertThat(user.getPassword()).isEqualTo("password");
        assertThat(user.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(user.getPassportNumber()).isEqualTo("A1234567");
        assertThat(user.getCity()).isEqualTo("New York");
        assertThat(user.getCountry()).isEqualTo("USA");
        assertThat(user.getRole()).isEqualTo(Roles.USER);
    }

    @Test
    void testToString() {
        Usero user = new Usero("1", "John", "Doe", "john.doe", "password", "john.doe@example.com", "A1234567", "New York", "USA", Roles.USER);
        String expectedString = "Usero(userId=1, firstName=John, lastName=Doe, username=john.doe, password=password, email=john.doe@example.com, passportNumber=A1234567, city=New York, country=USA, role=USER)";
        assertThat(user.toString()).isEqualTo(expectedString);
    }
 
}
