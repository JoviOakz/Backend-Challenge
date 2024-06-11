package com.bosch.example.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.User;
import com.bosch.example.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    @Autowired
    UserService repo;

    @GetMapping("user/{search}")
    public List<User> searchUsername(@PathVariable String search) {
        return repo.findByUsername(search);
    }

    @GetMapping("user")
    public List<User> getMethodName(String country) {
        return repo.findByCountry(country);
    }

    @PostMapping("/user")
    public String postMethodName(@RequestBody User user) {
        repo.save(user);

        return "Usuário criado com sucesso";
    }
}