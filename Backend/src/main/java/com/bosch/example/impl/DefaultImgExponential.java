package com.bosch.example.impl;

import com.bosch.example.dto.ImgExponentialResult;
import com.bosch.example.services.ImgExponential;

public class DefaultImgExponential implements ImgExponential {
    @Override
    public ImgExponentialResult calculate(Long A, Long b) {
        Double Re = A * Math.sin(b);
        Double Im = A * Math.cos(b);

        return new ImgExponentialResult(Re, Im);
    }
}