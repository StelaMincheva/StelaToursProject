package com.example.project.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


}
