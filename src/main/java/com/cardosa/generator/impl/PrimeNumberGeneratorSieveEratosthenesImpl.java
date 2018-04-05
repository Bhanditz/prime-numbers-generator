package com.cardosa.generator.impl;

import com.cardosa.generator.PrimeNumberGeneratorStrategy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type Prime number generator force brute.
 */
public class PrimeNumberGeneratorSieveEratosthenesImpl implements PrimeNumberGeneratorStrategy {

    @Override
    public List<Integer> calculate(Integer limit) {
        boolean prime[] = new boolean[limit + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= limit; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= limit; j += i) {
                    prime[j] = false;
                }
            }
        }
        return pickPrimeNumbers(prime, limit);
    }

    private List<Integer> pickPrimeNumbers(boolean[] primes, Integer limit) {
        return IntStream.rangeClosed(2, limit)
            .filter(i -> primes[i])
            .boxed()
            .collect(Collectors.toList());
    }
}
