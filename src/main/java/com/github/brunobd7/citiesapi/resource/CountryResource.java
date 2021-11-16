package com.github.brunobd7.citiesapi.resource;

import com.github.brunobd7.citiesapi.model.Country;
import com.github.brunobd7.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    CountryRepository countryRepository;

    /*@GetMapping
    public List<Country> listAll(){
        return countryRepository.findAll();
    }*/

    @GetMapping
    public Page<Country> listAllPageable(Pageable pageable){
        return countryRepository.findAll(pageable);
    }
}
