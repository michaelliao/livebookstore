package com.crackj2ee.bookstore.exception;

/**
 * This exception indicate that requested-action require a login before process 
 * this request.
 * 
 * @author Xuefeng
 */
public class NeedLoginException extends ApplicationException {

    public NeedLoginException() {
        super();
    }

    public NeedLoginException(String message) {
        super(message);
    }

}
