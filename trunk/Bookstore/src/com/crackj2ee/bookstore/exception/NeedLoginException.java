package com.crackj2ee.bookstore.exception;

public class NeedLoginException extends ApplicationException {

    public NeedLoginException() {
        super();
    }

    public NeedLoginException(String message) {
        super(message);
    }

}
