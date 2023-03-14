package com.oro.model1.exception;

public class CarPartNotFoundException extends RuntimeException {
    public CarPartNotFoundException(String message) {
        super(message);
    }
}
