package com.example.project.model.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public class OfferDto {

    private Long id;
    private String title;
    private String url;
    private String info;
    private String program;
    private BigDecimal price;
    private String priceIncludes;
    private String priceNotIncludes;
    private String requiredDocuments;
    private String methodOfPayment;
    private String minNumberOfTourists;
    private String typeOfTransport;
    private String duration;
    private LocalDate date;
    private Long destinationId;

    public OfferDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }
}
