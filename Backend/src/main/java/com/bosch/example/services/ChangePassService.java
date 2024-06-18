package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.CreateUser;

public interface ChangePassService {
    String save(CreateUser user);
    List<CreateUser> findByUsername(String username);
}