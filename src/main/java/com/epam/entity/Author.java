package com.epam.entity;

import javax.xml.bind.annotation.XmlElement;

public class Author {
    @XmlElement
    private String authorId;
    @XmlElement
    private String firstName;
    @XmlElement
    private String secondName;
    @XmlElement
    private String description;
    @XmlElement
    private String nationality;
    @XmlElement
    private String birthDate;
    @XmlElement
    private String birthCountry;
    @XmlElement
    private String birthCity;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    @Override
    public String toString() {
        return "Author1{" +
                "authorId='" + authorId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", description='" + description + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", birthCountry='" + birthCountry + '\'' +
                ", birthCity='" + birthCity + '\'' +
                '}';
    }
}
