package com.example.project.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "contacts")
public class Contact extends BaseEntity {

    @Length(min = 3, max = 60)
    @Column(name = "name", nullable = false)
    private String name;
    @Email
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "message", columnDefinition = "TEXT", nullable = false)
    private String message;

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
