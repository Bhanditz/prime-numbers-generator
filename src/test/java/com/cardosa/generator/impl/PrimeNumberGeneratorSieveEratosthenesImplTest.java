package com.cardosa.generator.impl;

import org.junit.Before;

/**
 * Created by jlcardosa on 04/04/2018.
 */
public class PrimeNumberGeneratorSieveEratosthenesImplTest extends AbstractPrimeNumberGeneratorTest {

    @Before
    public void setUp() throws Exception {
        primeNumberGeneratorStrategy = new PrimeNumberGeneratorSieveEratosthenesImpl();
    }
}
