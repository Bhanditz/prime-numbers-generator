
//Namespace
package com.cardosa.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Class that represents an API Response
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiMessageResponse {

    //Fields
    private String message;
    private HttpStatus status;
    private Date timestamp;

    /**
     * Constructor
     * @param status
     * @param message
     */
    public ApiMessageResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }

    //Getters and Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return new Date(this.timestamp.getTime());
    }
}
