package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.services.CPFValidator;

@RestController
public class CPFController {
    @Autowired
    CPFValidator validator;

    @GetMapping("/validate/{cpf}")
    public Boolean validate(@PathVariable String cpf) {
        return validator.validate(cpf);
    }
}