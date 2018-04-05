# Prime Number Generator

RESTful service which calculates and returns all the prime numbers up to and including a number provided.

## Technologies

* Java 8
* Spring Boot
* Gradle
* Caching

## Usage

Get the prime numbers according to an initial number and an algorithm

`GET /primes/{initial}?type={algorithm}`

* Initial   : The initial number to start calculating the prime numbers
* Algorithm : The type of algorithm to apply (SIEVE_ERATOSTHENES or FORCE_BRUTE)

`GET /primes/50`

`GET /primes/50?type=SIEVE_ERATOSTHENES`

`GET /primes/50?type=FORCE_BRUTE`

## Build the app and run tests

`./gradlew build`

## Running the code

`./gradlew bootRun`

### Examples

#### JSON Response

Request `curl -X GET -H "Accept: application/json" http://localhost:8080/primes/40?type=FORCE_BRUTE`\
Response `{"Initial":40,"Primes":[2,3,5,7,11,13,17,19,23,29,31,37]}`

#### XML Response

Request `curl -X GET -H "Accept: application/xml" http://localhost:8080/primes/10?type=SIEVE_ERATOSTHENES`\
Response `<PrimeNumberResponse><Initial>10</Initial><Primes><Primes>2</Primes><Primes>3</Primes><Primes>5</Primes><Primes>7</Primes></Primes></PrimeNumberResponse>`

### Live API

https://prime-numbers-generator.herokuapp.com/primes/50
