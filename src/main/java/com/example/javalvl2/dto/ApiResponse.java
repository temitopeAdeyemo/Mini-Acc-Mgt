package com.example.javalvl2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

@JsonIgnoreProperties(ignoreUnknown = true) // unknown properties that is not in the class properties would be ignored in the response without throwing an err
//@JsonInclude(JsonInclude.Include.NON_NULL) // Will exclude properties with null values
public class ApiResponse<T> {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private HttpStatus status;

    @JsonProperty("data")
    private T data;

    public ApiResponse(boolean success, HttpStatus statusCode, T data){
        this.success = success;
        this.status = statusCode;
        this.data = data;
    }
}
