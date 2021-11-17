package com.github.brunobd7.citiesapi.repository;

import com.github.brunobd7.citiesapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
