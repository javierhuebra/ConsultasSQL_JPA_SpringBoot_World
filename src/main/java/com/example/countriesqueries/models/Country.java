package com.example.countriesqueries.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    private int id;
    private char code;
    private char name;
    private char region;

    @Column(name = "surface_area")
    private float surfaceArea;

    private double lifeExpectancy;
    private char governmentForm;


    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<Language> languages;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<City> cities;


    public Country() {
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public char getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(char governmentForm) {
        this.governmentForm = governmentForm;
    }

    public char getRegion() {
        return region;
    }

    public void setRegion(char region) {
        this.region = region;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
}
