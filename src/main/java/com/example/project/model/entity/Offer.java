package com.example.project.model.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Length(min = 3, max = 70)
    @Column(name = "title", nullable = false)
    private String title;
    @OneToMany
    private List<Image> offerImages;
    @Column(name = "info", columnDefinition = "TEXT", nullable = false)
    private String info;
    @Column(name = "program", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String program;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "description", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String description;

    public Offer() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Image> getOfferImages() {
        return offerImages;
    }

    public void setOfferImages(List<Image> offerImages) {
        this.offerImages = offerImages;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
