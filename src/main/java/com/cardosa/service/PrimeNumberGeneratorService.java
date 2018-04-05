package com.cardosa.service;

import com.cardosa.model.PrimeNumberGeneratorType;
import com.cardosa.model.PrimeNumberResponse;

/**
 * The interface Prime number generator service.
 */
public interface PrimeNumberGeneratorService {

    /**
     * Generate up to prime number response.
     *
     * @param limit                    the limit
     * @param primeNumberGeneratorType the prime number generator type
     * @return the prime number response
     */
    PrimeNumberResponse generateUpTo(Integer limit, PrimeNumberGeneratorType primeNumberGeneratorType);
}
