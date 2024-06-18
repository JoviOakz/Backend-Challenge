package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.CreateUser;

public interface CreateUserService {
    String save(CreateUser user);
    List<CreateUser> findByUsername(String username);
    List<CreateUser> findByEmail(String email);
}