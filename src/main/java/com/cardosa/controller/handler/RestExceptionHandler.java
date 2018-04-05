//Namespace
package com.cardosa.controller.handler;

//Imports
import com.cardosa.exception.InvalidLimitPrimeNumberGenerator;
import com.cardosa.model.ApiMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class that handles the common exceptions of all controllers
 */
@ControllerAdvice
@RestController
public class RestExceptionHandler {

    @ExceptionHandler(value = {InvalidLimitPrimeNumberGenerator.class})
    public ResponseEntity<ApiMessageResponse> exceptionUserNotFound(InvalidLimitPrimeNumberGenerator e) {
        return new ResponseEntity<>(
                new ApiMessageResponse(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, e.getMessage()), HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE
        );
    }
}
