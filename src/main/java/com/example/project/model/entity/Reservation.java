package com.example.project.model.entity;

import com.example.project.model.enums.HotelCategory;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation extends BaseEntity {

    @Column(name = "number_of_adults", nullable = false)
    private int numberOfAdults;
    @Column(name = "number_of_kids")
    private int numberOfKids;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    @Column(name = "hotel_category", nullable = false)
    private HotelCategory hotelCategory;
    @Column(name = "number_of_insurances", nullable = false)
    private int numberOfInsurances;
    @ManyToOne
    private Offer offer;

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

    public HotelCategory getHotelCategory() {
        return hotelCategory;
    }

    public void setHotelCategory(HotelCategory hotelCategory) {
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
}
