package com.bosch.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bosch.example.model.CreateUser;

@Repository
public interface CreateUserJPARepository extends JpaRepository<CreateUser, Long> {
    List<CreateUser> findByUsernameContaining(String username);
    List<CreateUser> findByEmail(String email);
}