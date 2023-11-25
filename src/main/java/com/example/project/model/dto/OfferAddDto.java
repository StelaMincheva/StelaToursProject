package com.example.project.model.dto;

import com.example.project.validation.ImageAnnotation;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

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
    @NotBlank(message = "Enter a description!")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
