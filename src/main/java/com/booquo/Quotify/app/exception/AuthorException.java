package com.booquo.Quotify.app.exception;

public class AuthorException extends RuntimeException {
    public AuthorException(String message) {
        super(message);
    }

    public AuthorException(String message, Throwable cause) {
        super(message, cause);
    }
}