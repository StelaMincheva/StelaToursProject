package com.example.project.model.dto;

import jakarta.validation.constraints.NotNull;

public class CountryDto {
    @NotNull
    private String countryName;

    public CountryDto() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
