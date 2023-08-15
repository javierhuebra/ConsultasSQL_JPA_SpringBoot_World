package com.example.countriesqueries.repositories;

import com.example.countriesqueries.models.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Long> {
    //Consulta 4:
    @Query("SELECT l FROM Language l WHERE l.percentage > 0.89 ORDER BY l.percentage DESC")
    List<Language> findLanguagesWithPercentageGreaterThan89();
}
