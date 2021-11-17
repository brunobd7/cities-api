package com.github.brunobd7.citiesapi.resource;

import com.github.brunobd7.citiesapi.entities.Country;
import com.github.brunobd7.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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


    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
//        Country countryFounded = countryRepository.findById(id)
//                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        Country countryFounded = countryRepository.findById(id).orElse(null);

        return Objects.nonNull(countryFounded) ? ResponseEntity.ok(countryFounded) : ResponseEntity.notFound().build();
    }
}
