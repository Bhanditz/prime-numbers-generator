package com.cardosa.factory;

import com.cardosa.generator.PrimeNumberGeneratorStrategy;
import com.cardosa.generator.impl.PrimeNumberGeneratorForceBruteImpl;
import com.cardosa.generator.impl.PrimeNumberGeneratorSieveEratosthenesImpl;
import com.cardosa.model.PrimeNumberGeneratorType;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Prime number generator factory test.
 */
public class PrimeNumberGeneratorFactoryTest {

    private PrimeNumberGeneratorStrategy primeNumberGenerator;

    /**
     * Create.
     *
     * @throws Exception the exception
     */
    @Test
    public void create() throws Exception {
        primeNumberGenerator = PrimeNumberGeneratorFactory.create(PrimeNumberGeneratorType.FORCE_BRUTE);
        assertThat(primeNumberGenerator, Matchers.instanceOf(PrimeNumberGeneratorForceBruteImpl.class));
        primeNumberGenerator = PrimeNumberGeneratorFactory.create(PrimeNumberGeneratorType.SIEVE_ERATOSTHENES);
        assertThat(primeNumberGenerator, Matchers.instanceOf(PrimeNumberGeneratorSieveEratosthenesImpl.class));
    }
}
