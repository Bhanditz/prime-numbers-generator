package com.cardosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PrimeNumbersGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeNumbersGeneratorApplication.class, args);
	}
}
