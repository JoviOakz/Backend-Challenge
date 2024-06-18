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
}