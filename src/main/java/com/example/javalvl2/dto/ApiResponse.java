package com.example.javalvl2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true) // unknown properties that is not in the class properties would be ignored in the response without throwing an err
//@JsonInclude(JsonInclude.Include.NON_NULL) // Will exclude properties with null values.
public class ApiResponse<T> {
    @JsonProperty("timeStamp")
    private final ZonedDateTime timeStamp;
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;

    public ApiResponse( String message, T data){
        this.timeStamp = ZonedDateTime.now(ZoneId.of("Z"));
        this.success = true;
        this.message = !message.isEmpty()? message : "OK";
        this.data = data;
    }
}
