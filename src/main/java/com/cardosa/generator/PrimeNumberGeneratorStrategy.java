package com.cardosa.generator;

import java.util.List;

/**
 * The interface Prime number generator strategy.
 */
public interface PrimeNumberGeneratorStrategy {

    /**
     * Calculate list.
     *
     * @param limit the limit
     * @return the list
     */
    List<Integer> calculate(Integer limit);
}
