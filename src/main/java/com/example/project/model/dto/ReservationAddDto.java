package com.example.project.model.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ReservationAddDto {
    @Min(1)
    @Max(value = 6, message = "The maximum number allowed is 6!")
    @NotNull(message = "Enter a number!")
    private int numberOfAdults;
    @Max(value = 6, message = "The maximum number allowed is 6!")
    private int numberOfKids;
    @Future(message = "Select a future date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Enter a date!")
    private LocalDate date;
    @NotNull(message = "Enter a hotel category!")
    private String hotelCategory;
    @NotNull(message = "Enter a number!")
    private int numberOfInsurances;

    public ReservationAddDto() {
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
}
