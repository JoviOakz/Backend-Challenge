package com.bosch.example.impl;

import com.bosch.example.services.CPFValidator;

public class DefaultCPFValidator implements CPFValidator{
    @Override
    public Boolean validate(String cpf) {
        System.out.println("Validei um caps tlgd");
        return true;
    }
}