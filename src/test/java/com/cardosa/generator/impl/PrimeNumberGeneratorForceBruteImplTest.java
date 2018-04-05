package com.cardosa.generator.impl;

import org.junit.Before;

public class PrimeNumberGeneratorForceBruteImplTest extends AbstractPrimeNumberGeneratorTest {

    @Before
    public void setUp() throws Exception {
        primeNumberGeneratorStrategy = new PrimeNumberGeneratorForceBruteImpl();
    }
}
