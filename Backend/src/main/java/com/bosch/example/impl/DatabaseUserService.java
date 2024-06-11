package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.User;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.UserService;

public class DatabaseUserService implements UserService{
    @Autowired
    UserJPARepository repo;

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return repo.findByCountry(country);
    }

    @Override
    public List<User> findByUsername(String username) {
        return repo.findByUsernameContaining(username);
    }
}