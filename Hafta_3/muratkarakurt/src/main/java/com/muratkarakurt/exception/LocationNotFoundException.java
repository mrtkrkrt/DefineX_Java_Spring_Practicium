package com.muratkarakurt.exception;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(String s) {
        super(s);
    }

    public LocationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
