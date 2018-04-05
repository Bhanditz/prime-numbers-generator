package com.cardosa.service.impl;

import com.cardosa.exception.InvalidLimitPrimeNumberGenerator;
import com.cardosa.model.PrimeNumberGeneratorType;
import com.cardosa.model.PrimeNumberResponse;
import com.cardosa.service.PrimeNumberGeneratorService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeNumberGeneratorServiceImplTest {

    private PrimeNumberGeneratorService primeNumberGeneratorService;

    @Before
    public void setUp() throws Exception {
        primeNumberGeneratorService = new PrimeNumberGeneratorServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
        primeNumberGeneratorService = null;
    }

    @Test
    public void generateUpTo() throws Exception {
        PrimeNumberResponse primeNumberResponse = primeNumberGeneratorService.generateUpTo(30, PrimeNumberGeneratorType.SIEVE_ERATOSTHENES);
        assertEquals(new Integer(30), primeNumberResponse.getInitial());
        assertArrayEquals(new Integer[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}, primeNumberResponse.getPrimes().toArray());
    }

    @Test(expected = InvalidLimitPrimeNumberGenerator.class)
    public void generateUpToWithNegativeNumber() throws Exception {
        primeNumberGeneratorService.generateUpTo(-5, PrimeNumberGeneratorType.SIEVE_ERATOSTHENES);
    }
}
