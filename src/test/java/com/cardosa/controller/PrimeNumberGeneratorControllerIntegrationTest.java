package com.cardosa.controller;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrimeNumberGeneratorControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void getPrimeNumbersJsonBody() {
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("/primes/30?type=FORCE_BRUTE", HttpMethod.GET, entity, String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("{\"Initial\":30,\"Primes\":[2,3,5,7,11,13,17,19,23,29]}", responseEntity.getBody());
    }

    @Test
    public void getPrimeNumbersXmlBody() {
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("/primes/10?type=FORCE_BRUTE", HttpMethod.GET, entity, String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("<PrimeNumberResponse>" +
                "<Initial>10</Initial>" +
                "<Primes><Primes>2</Primes><Primes>3</Primes><Primes>5</Primes><Primes>7</Primes></Primes>" +
                "</PrimeNumberResponse>",
            responseEntity.getBody());
    }

    @Test
    public void getPrimeNumbersWithNegativeLimit() {
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("/primes/-5", HttpMethod.GET, entity, String.class);

        assertEquals(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, responseEntity.getStatusCode());
        assertThat(responseEntity.getBody(), CoreMatchers.containsString("The initial value/limit cannot be less than 0"));
    }
}
