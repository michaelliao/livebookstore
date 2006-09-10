package com.crackj2ee.bookstore.exception;

/**
 * This exception indicate a login action failed because of invalid 
 * username and password.
 * 
 * @author Xuefeng
 */
public class LoginFailedException extends ApplicationException {

    public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message) {
        super(message);
    }

}
