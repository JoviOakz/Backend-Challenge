package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.CreateUser;
import com.bosch.example.services.ChangePassService;

@RestController
public class ChangePassController {
    @Autowired
    ChangePassService repo;

    @PatchMapping("changepassword")
    public String postMethodUser(@RequestBody CreateUser user) {
        return repo.save(user);
    }
}