package com.cardosa.service.impl;

import com.cardosa.exception.InvalidLimitPrimeNumberGenerator;
import com.cardosa.factory.PrimeNumberGeneratorFactory;
import com.cardosa.generator.PrimeNumberGeneratorStrategy;
import com.cardosa.model.PrimeNumberGeneratorType;
import com.cardosa.model.PrimeNumberResponse;
import com.cardosa.service.PrimeNumberGeneratorService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Prime number generator service.
 */
@Service
public class PrimeNumberGeneratorServiceImpl implements PrimeNumberGeneratorService {

    @Cacheable("primeNumberResponse")
    @Override
    public PrimeNumberResponse generateUpTo(Integer limit, PrimeNumberGeneratorType primeNumberGeneratorType) {
        this.validateLimit(limit);
        PrimeNumberGeneratorStrategy primeNumberGenerator = PrimeNumberGeneratorFactory.create(primeNumberGeneratorType);
        List<Integer> primeNumbers = primeNumberGenerator.calculate(limit);

        return new PrimeNumberResponse(limit, primeNumbers);
    }

    /**
     * Validate that the limit is less than 0
     *
     * @param limit Integer
     */
    private void validateLimit(Integer limit) {
        if (limit < 0) {
            throw new InvalidLimitPrimeNumberGenerator("The initial value/limit cannot be less than 0");
        }
    }
}
