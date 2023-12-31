package com.example.project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Length(min = 3, max = 70)
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne
    private Image offerImage;
    @Column(name = "info", columnDefinition = "TEXT", nullable = false)
    private String info;
    @Column(name = "program", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String program;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "price_includes", columnDefinition = "TEXT", nullable = false)
    private String priceIncludes;
    @Column(name = "price_not_includes", columnDefinition = "TEXT", nullable = false)
    private String priceNotIncludes;
    @Column(name = "required_documents",  columnDefinition = "TEXT", nullable = false)
    private String requiredDocuments;
    @Column(name = "method_of_payment", nullable = false)
    private String methodOfPayment;
    @Column(name = "min_number_of_tourists", nullable = false)
    private String minNumberOfTourists;
    @Column(name = "type_of_transport", nullable = false)
    private String typeOfTransport;
    @Column(name = "duration", nullable = false)
    private String duration;
    @Future
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @ManyToOne(optional = false)
    private Destination destination;

    public Offer() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(Image offerImage) {
        this.offerImage = offerImage;
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

    public String getPriceIncludes() {
        return priceIncludes;
    }

    public void setPriceIncludes(String priceIncludes) {
        this.priceIncludes = priceIncludes;
    }

    public String getPriceNotIncludes() {
        return priceNotIncludes;
    }

    public void setPriceNotIncludes(String priceNotIncludes) {
        this.priceNotIncludes = priceNotIncludes;
    }

    public String getRequiredDocuments() {
        return requiredDocuments;
    }

    public void setRequiredDocuments(String requiredDocuments) {
        this.requiredDocuments = requiredDocuments;
    }

    public String getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    public String getMinNumberOfTourists() {
        return minNumberOfTourists;
    }

    public void setMinNumberOfTourists(String minNumberOfTourists) {
        this.minNumberOfTourists = minNumberOfTourists;
    }

    public String getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}
