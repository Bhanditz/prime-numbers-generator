package com.cardosa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrimeNumberResponse {
    @JsonProperty("Initial")
    Integer initial;
    @JsonProperty(value="Primes")
    List<Integer> primes;

    public PrimeNumberResponse(Integer initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public Integer getInitial() {
        return initial;
    }

    public void setInitial(Integer initial) {
        this.initial = initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public void setPrimes(List<Integer> primes) {
        this.primes = primes;
    }
}
