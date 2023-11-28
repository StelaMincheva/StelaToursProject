package com.example.project.model.dto;

import com.example.project.model.entity.Offer;
import com.example.project.model.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public class UserProfileDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate birthdate;
    private List<Offer> favorites;
    private List<Reservation> upComingBookings;
    private List<Reservation> pastBookings;
    private int bonusPoints;

    public UserProfileDto() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Offer> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Offer> favorites) {
        this.favorites = favorites;
    }

    public List<Reservation> getUpComingBookings() {
        return upComingBookings;
    }

    public void setUpComingBookings(List<Reservation> upComingBookings) {
        this.upComingBookings = upComingBookings;
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
}
