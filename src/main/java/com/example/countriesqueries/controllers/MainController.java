package com.example.countriesqueries.controllers;

import com.example.countriesqueries.models.City;
import com.example.countriesqueries.models.Country;
import com.example.countriesqueries.models.Language;
import com.example.countriesqueries.services.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService){
        this.mainService = mainService;
    }

    @GetMapping("/countries-speaking-slovenian")
    public List<Object[]> getCountriesThatSpeakSlovene() {
        String language = "Slovene";
        return mainService.getCountriesThatSpeakSlovene(language);
    }

    @GetMapping("/countries-with-total-cities")
    public List<Object[]> getCountriesWithTotalCities() {
        return mainService.getCountriesWithTotalCities();
    }

    @GetMapping("/cities-in-mexico-with-population-greater-than-500k")
    public List<City> getCitiesInMexicoWithPopulationGreaterThan500k() {
        List<City> cities = mainService.getCitiesInMexicoWithPopulationGreaterThan500k();
        return cities;
    }

    @GetMapping("/languages-with-percentage-greater-than-89")
    public List<Language> getLanguagesWithPercentageGreaterThan89() {
        return mainService.getLanguagesWithPercentageGreaterThan89();
    }

    @GetMapping("/countries")
    public List<Country> getCountriesBySurfaceAreaAndTotalPopulation() {
        return mainService.getCountriesBySurfaceAreaAndTotalPopulation();
    }

    @GetMapping("/countries-criteria")
    public List<Country> getCountriesByCriteria() {
        return mainService.getCountriesByCriteria();
    }

    @GetMapping("/cities-in-argentina")
    public List<Object[]> getCitiesInArgentinaWithPopulationGreaterThan500k() {
        return mainService.getCitiesInArgentinaWithPopulationGreaterThan500k();
    }

    @GetMapping("/countries-by-region")
    public List<Object[]> countCountriesByRegion() {
        return mainService.countCountriesByRegion();
    }
}
