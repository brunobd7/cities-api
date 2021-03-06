package com.github.brunobd7.citiesapi.resource;

import com.github.brunobd7.citiesapi.entities.State;
import com.github.brunobd7.citiesapi.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource {

//    private final StateRepository repository;
//
//    public StateResource(final StateRepository repository) {
//        this.repository = repository;
//    }

    @Autowired
    private StateRepository repository;

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }
}
