package com.example.countriesqueries.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    private int id;
    private char language;
    private double percentage;

    @ManyToOne
    @JoinColumn(name = "country_code", referencedColumnName = "code")
    @JsonIgnore
    private Country country;


    public Language() {
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getLanguage() {
        return language;
    }

    public void setLanguage(char language) {
        this.language = language;
    }
}

