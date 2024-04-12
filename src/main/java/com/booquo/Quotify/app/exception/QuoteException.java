package com.booquo.Quotify.app.exception;

public class QuoteException extends RuntimeException {
    public QuoteException(String message) {
        super(message);
    }

    public QuoteException(String message, Throwable cause) {
        super(message, cause);
    }
}