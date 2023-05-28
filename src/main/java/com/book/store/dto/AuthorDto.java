package com.book.store.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AuthorDto {
    @NotEmpty(message = "*Please enter first name")
    @NotNull(message = "*Please enter first name")
    public String firstName;
    @NotEmpty(message = "*Please enter middle name")
    @NotNull(message = "*Please enter middle name")
    public String middleName;
    @NotEmpty(message = "*Please enter last name")
    @NotNull(message = "*Please enter last name")
    public String lastName;
    @NotEmpty(message = "*Please select gender")
    @NotNull(message = "*Please select gender")
    public String gender;
    @NotEmpty(message = "*Please enter email")
    @NotNull(message = "*Please enter email")
    public String email;
    public String biography;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
