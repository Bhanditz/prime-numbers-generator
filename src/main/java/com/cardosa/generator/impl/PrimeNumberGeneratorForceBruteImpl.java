package com.cardosa.generator.impl;

import com.cardosa.generator.PrimeNumberGeneratorStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Prime number generator force brute.
 */
public class PrimeNumberGeneratorForceBruteImpl implements PrimeNumberGeneratorStrategy {

    @Override
    public List<Integer> calculate(Integer limit) {
        return IntStream.rangeClosed(2, limit)
            .filter(this::isPrime)
            .boxed()
            .collect(Collectors.toList());
    }

    private boolean isPrime(int number) {
        return IntStream.range(2, number).noneMatch(x -> number % x == 0);
    }
}
