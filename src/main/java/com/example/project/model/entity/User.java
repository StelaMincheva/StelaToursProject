package com.example.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
    @ManyToMany
    private List<Offer> favorites;
    @ManyToMany
    private List<Reservation> upcomingBookings;
    @ManyToMany
    private List<Reservation> pastBookings;
    @Column(name = "bonus_points")
    private int bonusPoints;

    public User() {
        this.roles = new ArrayList<>();
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Offer> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Offer> favorites) {
        this.favorites = favorites;
    }

    public List<Reservation> getUpcomingBookings() {
        return upcomingBookings;
    }

    public void setUpcomingBookings(List<Reservation> upcomingBookings) {
        this.upcomingBookings = upcomingBookings;
    }

    public List<Reservation> getPastBookings() {
        return pastBookings;
    }

    public void setPastBookings(List<Reservation> pastBookings) {
        this.pastBookings = pastBookings;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
