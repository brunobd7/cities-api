package com.github.brunobd7.citiesapi.resource;

import com.github.brunobd7.citiesapi.entities.City;
import com.github.brunobd7.citiesapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CityResource {

    @Autowired
    CityRepository cityRepository;

//    private final CityRepository repository;
//
//    public CityResource(final CityRepository repository) {
//        this.repository = repository;
//    }

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable
    @GetMapping
    public Page<City> cities(final Pageable page) {
        return cityRepository.findAll(page);
    }
}
