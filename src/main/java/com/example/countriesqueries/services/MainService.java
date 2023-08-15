package com.example.countriesqueries.services;

import com.example.countriesqueries.models.City;
import com.example.countriesqueries.models.Country;
import com.example.countriesqueries.models.Language;
import com.example.countriesqueries.repositories.CityRepository;
import com.example.countriesqueries.repositories.CountryRepository;
import com.example.countriesqueries.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final LanguageRepository languageRepository;

    public MainService(CountryRepository countryRepository,
                       CityRepository cityRepository,
                       LanguageRepository languageRepository)
    {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.languageRepository = languageRepository;
    }

    //Consulta 1: Paises que hablan Sloveno ordenados por porcentaje de forma descendente
    public List<Object[]> getCountriesThatSpeakSlovene(String language) {
        char[] languageCharArray = language.toCharArray();
        return countryRepository.findCountriesThatSpeakSlovene(languageCharArray);
    }

    //Consulta 2: Número total de ciudades de cada país ordenados por número de ciudades en orden descendente
    public List<Object[]> getCountriesWithTotalCities() {
        return countryRepository.findCountriesWithTotalCities();
    }

    //Consulta 3: Ciudades en México con población mayor a 500,000, ordenadas por población en orden descendente
    public List<City> getCitiesInMexicoWithPopulationGreaterThan500k() {
        return cityRepository.findCitiesInMexicoWithPopulationGreaterThan500k();
    }

    //Consulta 4: Lenguajes en cada pais con un porcentaje > 89% -> (0.89)
    public List<Language> getLanguagesWithPercentageGreaterThan89() {
        return languageRepository.findLanguagesWithPercentageGreaterThan89();
    }
    //Consulta 5: Paises con superficie de area < 501 y poblacion > 100000
    public List<Country> getCountriesBySurfaceAreaAndTotalPopulation() {
        return countryRepository.findCountriesBySurfaceAreaAndTotalPopulation();
    }

    //Consulta 6: Paises que tienen solo monarquias y una superficie > 200 y una expectativa de vida > 75 años
    public List<Country> getCountriesByCriteria() {
        return countryRepository.findCountriesByCriteria();
    }

    //Consula 7: Ciudades de Argentina dentro de BSAS con poblacion > 500000
    public List<Object[]> getCitiesInArgentinaWithPopulationGreaterThan500k() {
        return cityRepository.findCitiesInArgentinaWithPopulationGreaterThan500k();
    }

    //Consulta 8: Sumar numero de paises de cada region
    public List<Object[]> countCountriesByRegion() {
        return countryRepository.countCountriesByRegion();
    }
}
