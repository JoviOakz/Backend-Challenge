package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.CwbRegisterResult;
import com.bosch.example.services.CwbRegisterService;

@RestController
public class CwbRegisterController {
    @Autowired
    CwbRegisterService validator;

    @GetMapping("curitiba")
    public CwbRegisterResult validate(@RequestParam String cep, @RequestParam String cpf) {
        String cepValidated = validator.validateCEP(cep);
        String cpfValidated = validator.validateCPF(cpf);

        if (!cepValidated.equals("Verificado") && !cpfValidated.equals("Verificado")) {
            return new CwbRegisterResult("CEP inválido", "CPF inválido");
        } else if (!cepValidated.equals("Verificado") && cpfValidated.equals("Verificado")) {
            return new CwbRegisterResult("CEP inválido", cpfValidated);
        } else if (cepValidated.equals("Verificado") && !cpfValidated.equals("Verificado")) {
            return new CwbRegisterResult(cepValidated, "CPF inválido");
        } else {
            return new CwbRegisterResult(cepValidated, cpfValidated);
        }
    }
}