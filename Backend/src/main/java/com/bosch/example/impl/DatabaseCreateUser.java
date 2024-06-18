package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.CreateUser;
import com.bosch.example.repositories.CreateUserJPARepository;
import com.bosch.example.services.CreateUserService;

public class DatabaseCreateUser implements CreateUserService {
    @Autowired
    CreateUserJPARepository repo;

    @Override
    public String save(CreateUser user) {
        repo.save(user);
        return "a";
    }

    @Override
    public List<CreateUser> findByUsername(String username) {
        return repo.findByUsernameContaining(username);
    }

    @Override
    public List<CreateUser> findByEmail(String email) {
        return repo.findByEmail(email);
    }
}