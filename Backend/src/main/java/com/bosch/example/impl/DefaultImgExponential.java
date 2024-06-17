package com.bosch.example.impl;

import com.bosch.example.dto.ImgExponentialResult;
import com.bosch.example.services.ImgExponentialService;

public class DefaultImgExponential implements ImgExponentialService {
    @Override
    public ImgExponentialResult calculate(Long A, Long b) {
        Double Re = A * Math.sin(b);
        Double Im = A * Math.cos(b);

        return new ImgExponentialResult(Re, Im);
    }
}