package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.services.Collatz;

@RestController
public class CollatzController {
    @Autowired
    Collatz validator;

    @GetMapping("collatz")
    public Integer validate(@RequestParam Integer current, @RequestParam Integer step) {
        return validator.collatz(current, step);
    }
}