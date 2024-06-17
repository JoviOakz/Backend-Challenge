package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DatabaseCitiesService;
import com.bosch.example.impl.DefaultCollatz;
import com.bosch.example.impl.DefaultCwbRegister;
import com.bosch.example.impl.DefaultImgExponential;
import com.bosch.example.impl.DefaultReverse;
import com.bosch.example.services.CitiesService;
import com.bosch.example.services.CollatzService;
import com.bosch.example.services.CwbRegisterService;
import com.bosch.example.services.ImgExponentialService;
import com.bosch.example.services.ReverseService;

@Configuration
public class DependenciesConfiguration {
    @Bean
    @Scope("singleton")
    public ReverseService reverse() {
        return new DefaultReverse();
    }

    @Bean
    @Scope("singleton")
    public CollatzService collatz() {
        return new DefaultCollatz();
    }

    @Bean
    @Scope("singleton")
    public ImgExponentialService imgExponential() {
        return new DefaultImgExponential();
    }

    @Bean
    @Scope("singleton")
    public CwbRegisterService cwbRegister() {
        return new DefaultCwbRegister();
    }

    @Bean
    @Scope("singleton")
    public CitiesService citiesService() {
        return new DatabaseCitiesService();
    }
}