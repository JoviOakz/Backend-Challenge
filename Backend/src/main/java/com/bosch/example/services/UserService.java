package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.User;

public interface UserService {
    void save(User user);
    List<User> findByCountry(String country);
    List<User> findByUsername(String username);
}