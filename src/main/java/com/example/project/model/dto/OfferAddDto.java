package com.example.project.model.dto;

import com.example.project.model.entity.Destination;
import com.example.project.validation.ImageAnnotation;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OfferAddDto {

    @Size(min = 3, max = 70, message = "Title length must be between 3 and 70 characters!")
    @NotNull
    private String title;
    @ImageAnnotation(contentTypes = {"image/jpeg", "image/png"})
    private MultipartFile offerImage;
    @NotBlank(message = "Enter an info!")
    private String info;
    @NotBlank(message = "Enter a program!")
    private String program;
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater then zero!")
    @NotNull(message = "Enter a price!")
    private BigDecimal price;
    @NotBlank(message = "Enter an item!")
    private String priceIncludes;
    @NotBlank(message = "Enter an item!")
    private String priceNotIncludes;
    @NotBlank(message = "Enter a document!")
    private String requiredDocuments;
    @NotBlank(message = "Enter a method of payment!")
    private String methodOfPayment;
    @NotBlank(message = "Enter a number!")
    private String minNumberOfTourists;
    @NotBlank(message = "Enter a type of transport!")
    private String typeOfTransport;
    @NotBlank(message = "Enter a duration!")
    private String duration;
    @Future(message = "Select a future date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Enter a date!")
    private LocalDate date;
    @NotNull(message = "Select a destination!")
    private Destination destination;

    public OfferAddDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(MultipartFile offerImage) {
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
