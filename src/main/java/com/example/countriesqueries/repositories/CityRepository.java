package com.example.countriesqueries.repositories;

import com.example.countriesqueries.models.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City,Long> {
    //Consulta 3:
    @Query("SELECT c FROM City c WHERE c.country.code = 'MEX' AND c.population > 500000 ORDER BY c.population DESC")
    List<City> findCitiesInMexicoWithPopulationGreaterThan500k();

    //Consula 7:
    @Query("SELECT c.country.name AS countryName, c.name AS cityName, c.district AS district, c.population AS population " +
            "FROM City c " +
            "WHERE c.country.name = 'Argentina' " +
            "AND c.district = 'Buenos Aires' " +
            "AND c.population > 500000")
    List<Object[]> findCitiesInArgentinaWithPopulationGreaterThan500k();
}
