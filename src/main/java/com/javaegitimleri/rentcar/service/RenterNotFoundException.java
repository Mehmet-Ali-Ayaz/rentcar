package com.javaegitimleri.rentcar.service;

public class RenterNotFoundException extends RuntimeException {
    public RenterNotFoundException(String message) {
        super(message);
    }
}
