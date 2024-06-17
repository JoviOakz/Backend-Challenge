package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.ReverseResult;
import com.bosch.example.services.ReverseService;

@RestController
public class ReverseController {
    @Autowired
    ReverseService validator;

    @GetMapping("reverse/{word}")
    public ReverseResult validate(@PathVariable String word) {
        String result = validator.reverse(word);
        Boolean palindrome = validator.palindrome(word, result);

        return new ReverseResult(result, palindrome);
    }
}