// // package ua.tqs.airportManager.entity;

// // import jakarta.persistence.*;
// // import lombok.AllArgsConstructor;
// // import lombok.Getter;
// // import lombok.NoArgsConstructor;
// // import lombok.Setter;
// // import lombok.ToString;
// // import ua.tqs.airportManager.Roles;

// // @Getter
// // @Setter
// // @Entity
// // @NoArgsConstructor
// // @AllArgsConstructor
// // @ToString
// // @Table(name = "accounts")
// // public class User {

// //     @Id
// //     @Column(name="userId", nullable = false, unique = true)
// //     private String userId;

// //     @Column(name="username", nullable = false, unique = true)
// //     private String username;

// //     @Basic
// //     @Column(name = "firstName", nullable = false)
// //     String firstName;

// //     @Column(name = "lastName", nullable = false)
// //     String lastName;

// //     @Column(name = "userPassword", nullable = false)
// //     String password;

// //     @Column(name = "email")
// //     String email;

// //     @Column(name = "passportNumber")
// //     String passportNumber;

// //     @Column(name = "city", nullable = false)
// //     String city;

// //     @Column(name = "country", nullable = false)
// //     String country;

// //     @Enumerated(EnumType.STRING) 
// //     Roles role;
// // }

// package ua.tqs.airportManager.entity;

// import java.util.Collection;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import jakarta.persistence.Basic;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;
// import ua.tqs.airportManager.Roles;

// @Getter
// @Setter
// @Entity
// @NoArgsConstructor
// @AllArgsConstructor
// @ToString
// @Table(name="accounts")
// public class User implements UserDetails {

//     @Id
//     @Column(name = "userId", nullable = false, unique = true)
//     private String userId;

//     @Column(name = "username", nullable = false, unique = true)
//     private String username;

//     @Basic
//     @Column(name = "firstName", nullable = false)
//     private String firstName;

//     @Column(name = "lastName", nullable = false)
//     private String lastName;

//     @Column(name = "userPassword", nullable = false)
//     private String password;

//     @Column(name = "email")
//     private String email;

//     @Column(name = "passportNumber")
//     private String passportNumber;

//     @Column(name = "city", nullable = false)
//     private String city;

//     @Column(name = "country", nullable = false)
//     private String country;

//     @Enumerated(EnumType.STRING) 
//     private Roles role;

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return List.of(new SimpleGrantedAuthority(role.name()));
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//        return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
// }

package ua.tqs.airportManager.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
// @AllArgsConstructor
@ToString
@Table(name = "accounts")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", nullable = false, unique = true)
    private int userId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Basic
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "userPassword", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "passportNumber")
    private String passportNumber;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Enumerated(EnumType.STRING)
    private Roles role;


    // Custom constructor without userId
    public User(String username, String firstName, String lastName, String password, String email,
            String passportNumber, String city, String country, Roles role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.passportNumber = passportNumber;
        this.city = city;
        this.country = country;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
