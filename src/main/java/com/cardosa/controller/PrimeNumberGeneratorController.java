package com.cardosa.controller;

import com.cardosa.model.PrimeNumberGeneratorType;
import com.cardosa.model.PrimeNumberResponse;
import com.cardosa.service.PrimeNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrimeNumberGeneratorController {

    @Autowired
    private PrimeNumberGeneratorService primeNumberGeneratorService;

    @GetMapping(value = "/primes/{limit}")
    public ResponseEntity<PrimeNumberResponse> calculatePrimes(
        @PathVariable(value = "limit") Integer limit,
        @RequestParam(name = "type", defaultValue = "SIEVE_ERATOSTHENES") PrimeNumberGeneratorType primeNumberGeneratorType)
    {
        PrimeNumberResponse primeNumberResponse = primeNumberGeneratorService.generateUpTo(limit, primeNumberGeneratorType);
        return new ResponseEntity<>(primeNumberResponse, HttpStatus.OK);
    }
}
