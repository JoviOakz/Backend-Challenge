package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DefaultReverse;
import com.bosch.example.services.Reverse;

@Configuration
public class DependenciesConfiguration {
    @Bean
    @Scope("singleton")
    public Reverse reverse() {
        return new DefaultReverse();
    }
}