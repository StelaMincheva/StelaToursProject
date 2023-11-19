package com.example.project.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {

    @Size(min = 2, max = 30, message = "First name length must be between 2 and 30 characters!")
    @NotNull
    private String firstName;
    @Size(min = 2, max = 30, message = "Last name length must be between 2 and 30 characters!")
    @NotNull
    private String lastName;
    @Email
    @NotBlank(message = "Email cannot be empty!")
    private String email;
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters!")
    @NotNull
    private String password;
    @NotNull
    private String passwordConfirm;

    public UserRegisterDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
