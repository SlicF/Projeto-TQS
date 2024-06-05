package ua.tqs.airportManager.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ua.tqs.airportManager.Roles;

class UserTest {

    @Test
    void testNoArgsConstructor() {
        User user = new User();
        assertThat(user).isNotNull();
    }

    @Test
    void testAllArgsConstructor() {
        User user = new User("john.doe", "John", "Doe", "password", "john.doe@example.com", "A1234567", "New York", "USA", Roles.USER);
        assertThat(user.getUsername()).isEqualTo("john.doe");
        assertThat(user.getFirstName()).isEqualTo("John");
        assertThat(user.getLastName()).isEqualTo("Doe");
        assertThat(user.getPassword()).isEqualTo("password");
        assertThat(user.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(user.getPassportNumber()).isEqualTo("A1234567");
        assertThat(user.getCity()).isEqualTo("New York");
        assertThat(user.getCountry()).isEqualTo("USA");
        assertThat(user.getRole()).isEqualTo(Roles.USER);
    }

    @Test
    void testSettersAndGetters() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("john.doe");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("password");
        user.setEmail("john.doe@example.com");
        user.setPassportNumber("A1234567");
        user.setCity("New York");
        user.setCountry("USA");
        user.setRole(Roles.USER);

        assertThat(user.getUserId()).isEqualTo(1);
        assertThat(user.getUsername()).isEqualTo("john.doe");
        assertThat(user.getFirstName()).isEqualTo("John");
        assertThat(user.getLastName()).isEqualTo("Doe");
        assertThat(user.getPassword()).isEqualTo("password");
        assertThat(user.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(user.getPassportNumber()).isEqualTo("A1234567");
        assertThat(user.getCity()).isEqualTo("New York");
        assertThat(user.getCountry()).isEqualTo("USA");
        assertThat(user.getRole()).isEqualTo(Roles.USER);
    }

    @Test
    void testToString() {
        User user = new User("john.doe", "John", "Doe", "password", "john.doe@example.com", "A1234567", "New York", "USA", Roles.USER);
        String expectedString = "User(userId=0, username=john.doe, firstName=John, lastName=Doe, password=password, email=john.doe@example.com, passportNumber=A1234567, city=New York, country=USA, role=USER)";
        assertThat(user).hasToString(expectedString);
    }

    @Test
    void testUserDetailsMethods() {
        User user = new User("john.doe", "John", "Doe", "password", "john.doe@example.com", "A1234567", "New York", "USA", Roles.USER);

        assertThat(user.isAccountNonExpired()).isTrue();
        assertThat(user.isAccountNonLocked()).isTrue();
        assertThat(user.isCredentialsNonExpired()).isTrue();
        assertThat(user.isEnabled()).isTrue();
    }
}
