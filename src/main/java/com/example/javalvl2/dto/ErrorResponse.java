package com.example.javalvl2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;


public class ErrorResponse extends Throwable{
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("statusCode")
    private HttpStatus statusCode;


    public ErrorResponse(boolean success, HttpStatus statusCode){
        this.success = success;
        this.statusCode = statusCode;
    }
}
