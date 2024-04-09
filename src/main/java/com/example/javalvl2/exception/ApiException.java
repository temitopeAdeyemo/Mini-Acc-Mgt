package com.example.javalvl2.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
public class ApiException<T> {
    private final ZonedDateTime timeStamp;
    private final Boolean success;
    private final String message;
    private final T data;

    public ApiException( String message, /*Throwable throwable,*/  T data) {
        this.timeStamp = ZonedDateTime.now(ZoneId.of("Z"));
        this.success = false;
        this.message = message;

        this.data = data;

    }

}
