package com.cardosa.factory;

import com.cardosa.generator.PrimeNumberGeneratorStrategy;
import com.cardosa.generator.impl.PrimeNumberGeneratorForceBruteImpl;
import com.cardosa.generator.impl.PrimeNumberGeneratorSieveEratosthenesImpl;
import com.cardosa.model.PrimeNumberGeneratorType;

/**
 * The type Prime number generator factory.
 */
public class PrimeNumberGeneratorFactory {

    /**
     * Create prime number generator strategy.
     *
     * @param primeNumberGeneratorType the prime number generator type
     * @return the prime number generator strategy
     */
    public static PrimeNumberGeneratorStrategy create(PrimeNumberGeneratorType primeNumberGeneratorType) {
        switch (primeNumberGeneratorType) {
            case FORCE_BRUTE:
                return new PrimeNumberGeneratorForceBruteImpl();
            case SIEVE_ERATOSTHENES:
                return new PrimeNumberGeneratorSieveEratosthenesImpl();
            default:
                return new PrimeNumberGeneratorSieveEratosthenesImpl();
        }
    }
}
