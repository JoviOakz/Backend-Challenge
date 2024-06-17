package com.bosch.example.impl;

import com.bosch.example.services.CwbRegisterService;

public class DefaultCwbRegister implements CwbRegisterService {
    @Override
    public String validateCEP(String cep) {

        return "a";
    }

    @Override
    public String validateCPF(String cpf) {
        if (cpf.length() != 11) {
            return "Erro";
        }
    
        int j = 11;
        int sum = 0;
    
        for (int i = 0; i <= (cpf.length() - 3); i++, j--) {
            sum += cpf.charAt(i) * (j - 1);
        }
    
        int x = 11 - (sum % 11);
        j = 11;
        sum = 0;
    
        if (x >= 10) {
            x = 0;
        }
    
        for (int w = 0; w <= (cpf.length() - 2); w++, j--) {
            sum += cpf.charAt(w) * j;
        }
    
        int y = 11 - (sum % 11);
    
        if (y >= 10) {
            y = 0;
        }
    
        if (cpf.charAt(9) == x && cpf.charAt(10) == y) {
            return "Verificado";
        }
        else {
            return "Erro";
        }
    }
}