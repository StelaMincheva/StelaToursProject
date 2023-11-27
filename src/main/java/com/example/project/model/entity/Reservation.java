package com.example.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation extends BaseEntity {

    @Column(name = "number_of_adults", nullable = false)
    private int numberOfAdults;
    @Column(name = "number_of_kids")
    private int numberOfKids;
    @Future
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "hotel_category", nullable = false)
    private String hotelCategory;
    @Column(name = "number_of_insurances", nullable = false)
    private int numberOfInsurances;
    @ManyToOne(optional = false)
    private Offer offer;
    @ManyToOne
    private User reservedBy;

    public Reservation() {
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfKids() {
        return numberOfKids;
    }

    public void setNumberOfKids(int numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHotelCategory() {
        return hotelCategory;
    }

    public void setHotelCategory(String hotelCategory) {
        this.hotelCategory = hotelCategory;
    }

    public int getNumberOfInsurances() {
        return numberOfInsurances;
    }

    public void setNumberOfInsurances(int numberOfInsurances) {
        this.numberOfInsurances = numberOfInsurances;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public User getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }
}
