package com.javaegitimleri.rentcar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RenterNotFoundException extends RuntimeException {
    public RenterNotFoundException(String message) {
        super(message);
    }
}
