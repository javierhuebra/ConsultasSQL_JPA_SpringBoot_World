package com.example.countriesqueries.repositories;

import com.example.countriesqueries.models.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {
    //Consulta 1: Hecho con query nativa
    @Query(nativeQuery = true, value = "SELECT c.name AS countryName, l.language AS language, l.percentage AS percentage " +
            "FROM countries c JOIN languages l ON c.code = l.country_code " +
            "WHERE l.language = :language " +
            "ORDER BY l.percentage DESC")
    List<Object[]> findCountriesThatSpeakSlovene(@Param("language") char[] language);

    //Consulta 2:
    @Query("SELECT c.name AS countryName, COUNT(ci) AS totalCities " +
            "FROM Country c LEFT JOIN c.cities ci " +
            "GROUP BY c.name " +
            "ORDER BY totalCities DESC")
    List<Object[]> findCountriesWithTotalCities();

    //Consulta 5:
    @Query("SELECT c FROM Country c WHERE c.surfaceArea < 501 AND (SELECT SUM(city.population) FROM City city WHERE city.country = c) > 100000")
    List<Country> findCountriesBySurfaceAreaAndTotalPopulation();

    //Consulta 6:
    @Query("SELECT c FROM Country c " +
            "WHERE c.governmentForm = 'Constitutional Monarchy' " +
            "AND c.surfaceArea > 200 " +
            "AND c.lifeExpectancy > 75")
    List<Country> findCountriesByCriteria();

    //Consulta 8:
    @Query("SELECT c.region AS regionName, COUNT(c) AS numberOfCountries " +
            "FROM Country c " +
            "GROUP BY c.region " +
            "ORDER BY numberOfCountries DESC")
    List<Object[]> countCountriesByRegion();

}
