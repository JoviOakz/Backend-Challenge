package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.CollatzResult;
import com.bosch.example.services.CollatzService;

@RestController
public class CollatzController {
    @Autowired
    CollatzService validator;

    @GetMapping("/collatz")
    public CollatzResult validate(@RequestParam Integer current, @RequestParam Integer step) {
        current = validator.collatz(current, step);

        return new CollatzResult(current);
    }
}