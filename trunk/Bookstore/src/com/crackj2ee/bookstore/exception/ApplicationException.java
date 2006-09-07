package com.crackj2ee.bookstore.exception;

public class ApplicationException extends RuntimeException {

    public ApplicationException() {
        super();
    }

    public ApplicationException(Throwable t) {
        super(t);
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable t) {
        super(message, t);
    }

}
