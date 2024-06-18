package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.CreateUser;
import com.bosch.example.repositories.CreateUserJPARepository;
import com.bosch.example.services.CreateUserService;

public class DatabaseCreateUser implements CreateUserService {
    @Autowired
    CreateUserJPARepository repo;

    @Override
    public String save(CreateUser user) {
        if (validateEmail(user) == false)
            return "Erro! Email precisa de '@' ou Email já foi cadastrado!";
        
        if (validateUsername(user) == false)
            return "Erro! Este Username já está em uso ou não está dentro dos requerimentos!";
        
        if (validatePassword(user) == false)
            return "Erro! Password precisa atender aos requisitos!";
        
        repo.save(user);
        return "Usuário cadastado com sucesso!";
    }

    @Override
    public List<CreateUser> findByUsername(String username) {
        return repo.findByUsernameContaining(username);
    }

    @Override
    public List<CreateUser> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Boolean validateUsername(CreateUser user) {
        String current_username = user.getUsername();
        List<CreateUser> db_username = findByUsername(current_username);

        if (current_username.length() < 4)
            return false;

        if (!db_username.isEmpty())
            return false;

        return true;
    }

    public Boolean validateEmail(CreateUser user) {
        String current_email = user.getEmail();
        List<CreateUser> db_email = findByEmail(current_email);

        if (current_email.length() < 4)
            return false;

        if (!current_email.contains("@")) 
            return false;

        if (!db_email.isEmpty())
            return false;

        return true;
    }

    public Boolean validatePassword(CreateUser user) {
        String current_password = user.getPassword();
        Boolean hasUpper = false;
        Boolean hasLower = false;
        Boolean hasNumber = false;

        if (current_password.length() < 8)
            return false;

        for (int i = 0; i < current_password.length(); i++) {
            if (Character.isUpperCase(current_password.charAt(i)))
                hasUpper = true;

            if (Character.isLowerCase(current_password.charAt(i)))
                hasLower = true;

            if (!Character.isDigit(current_password.charAt(i)))
                hasNumber = true;
        }

        if (hasUpper == false)
            return false;
        else if (hasLower == false)
            return false;
        else if (hasNumber == false)
            return false;
        else
            return true;
    }
}