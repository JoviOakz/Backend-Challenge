package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DefaultCPFValidator;
import com.bosch.example.impl.MockUserService;
import com.bosch.example.services.CPFValidator;
import com.bosch.example.services.UserService;

@Configuration
public class DependenciesConfiguration {
    @Bean
    @Scope("singleton")
    public UserService userService() {
        return new MockUserService();
    }

    @Bean
    @Scope("singleton")
    public CPFValidator cpfValidator() {
        return new DefaultCPFValidator();
    }
}