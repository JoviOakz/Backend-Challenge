package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.City;

public interface CitiesService {
    List<City> findByCityContaining(String parameter);
    List<City> findAll();
}