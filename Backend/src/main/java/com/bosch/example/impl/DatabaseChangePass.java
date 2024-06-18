package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.model.CreateUser;
import com.bosch.example.repositories.CreateUserJPARepository;
import com.bosch.example.services.ChangePassService;

public class DatabaseChangePass implements ChangePassService {
    @Autowired
    CreateUserJPARepository repo;

    @Override
    public String save(CreateUser user) {
        repo.save(user);
        return "Senha atualizada com sucesso!";
    }

    @Override
    public List<CreateUser> findByUsername(String username) {
        return repo.findByUsernameContaining(username);
    }

    public Boolean usernameExist(CreateUser user) {
        String current_username = user.getUsername();
        List<CreateUser> db_username = findByUsername(current_username);
        
        if (db_username.isEmpty())
            return false;

        return true;
    }

    public Boolean validatePassword(CreateUser user) {
        String current_password = user.getPassword();
        List<CreateUser> db_password = findByUsername(current_password);

        for (CreateUser username : db_password) {
            String password = username.getPassword();

            if (current_password == password) {
                return true;
            }
        }

        if (db_password.isEmpty())
            return false;

        return true;
    }

    public Boolean validateNewPassword(CreateUser user) {
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