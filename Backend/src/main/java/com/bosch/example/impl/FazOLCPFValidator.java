package com.bosch.example.impl;

import com.bosch.example.services.CPFValidator;

public class FazOLCPFValidator implements CPFValidator{
    @Override
    public Boolean validate(String cpf) {
        System.out.println("Faz o L KKKK");
        return true;
    }
}