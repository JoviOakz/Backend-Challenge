package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.CreateUser;
import com.bosch.example.services.CreateUserService;

@RestController
public class CreateUserController {
    @Autowired
    CreateUserService repo;

    @PostMapping("create")
    public void postMethodUser(@RequestBody CreateUser user) {
        repo.save(user);
    }
}