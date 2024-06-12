package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.ImgExponentialResult;
import com.bosch.example.services.ImgExponential;

@RestController
public class ImgExponentialController {
    @Autowired
    ImgExponential validator;

    @GetMapping("imaexp")
    public ImgExponentialResult validate(@RequestParam Long A, @RequestParam Long b) {
        return validator.calculate(A, b);
    }
}