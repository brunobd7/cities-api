package com.github.brunobd7.citiesapi.repository;

import com.github.brunobd7.citiesapi.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
