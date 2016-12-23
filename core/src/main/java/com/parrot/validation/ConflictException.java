package com.parrot.validation;

public class ConflictException extends RuntimeException {

    public ConflictException() {

    }

    public ConflictException(String message) {
        super(message);
    }
}
