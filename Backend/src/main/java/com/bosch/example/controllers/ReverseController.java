package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.services.Reverse;

@RestController
public class ReverseController {
    @Autowired
    Reverse validator;

    @GetMapping("/reverse/{word}")
    public String validate(@PathVariable String word) {
        return validator.reverse(word);
    }
}