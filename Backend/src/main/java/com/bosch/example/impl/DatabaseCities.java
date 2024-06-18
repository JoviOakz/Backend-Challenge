package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.City;
import com.bosch.example.repositories.CitiesJPARepository;
import com.bosch.example.services.CitiesService;

public class DatabaseCities implements CitiesService {
    @Autowired
    CitiesJPARepository repo;

    @Override
    public List<City> findByCityContaining(String parameter) {
        return repo.findByCityContaining(parameter);
    }

    @Override
    public List<City> findAll() {
        return repo.findAll();
    }
}