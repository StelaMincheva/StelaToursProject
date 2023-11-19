package com.example.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Length(min = 2, max = 30)
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Length(min = 2, max = 30)
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Length(min = 5, max = 15)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Past
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToMany
    private Set<Role> roles;
    @OneToMany
    private Set<Offer> favorites;
    @OneToMany
    private Set<Reservation> upcomingBookings;
    @OneToMany
    private Set<Reservation> pastBookings;
    @Column(name = "bonus_points")
    private int bonusPoints;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Offer> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Offer> favorites) {
        this.favorites = favorites;
    }

    public Set<Reservation> getUpcomingBookings() {
        return upcomingBookings;
    }

    public void setUpcomingBookings(Set<Reservation> upcomingBookings) {
        this.upcomingBookings = upcomingBookings;
    }

    public Set<Reservation> getPastBookings() {
        return pastBookings;
    }

    public void setPastBookings(Set<Reservation> pastBookings) {
        this.pastBookings = pastBookings;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
}
