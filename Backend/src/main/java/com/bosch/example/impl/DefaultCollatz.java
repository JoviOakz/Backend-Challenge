package com.bosch.example.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.bosch.example.services.Collatz;

public class DefaultCollatz implements Collatz {
    @Override
    public Integer collatz(int current, int step) {
        if (current < 1 || step < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Input!");
        } else {
            for (int i = 0; i < step; i++) {
                if (current % 2 == 0) 
                    current /= 2;
                else
                    current = (3 * current) + 1;
            }

            System.out.println(current);
            return current;
        }
    }
}