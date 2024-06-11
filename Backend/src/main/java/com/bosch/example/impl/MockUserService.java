package com.bosch.example.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.User;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.UserService;

public class MockUserService implements UserService{
    private List<User> users = new ArrayList<>();

    public MockUserService() {
        var user = new User();

        user = new User();
        user.setId(1l);
        user.setCountry("Brazil");
        user.setUsername("Don");
        users.add(user);
        
        user = new User();
        user.setId(1l);
        user.setCountry("Brazil");
        user.setUsername("Niltin");
        users.add(user);
    }

    @Autowired
    UserJPARepository repo;

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return users.stream().filter(u -> u.getCountry().equals(country)).toList();
    }

    @Override
    public List<User> findByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().contains(username)).toList();
    }
}