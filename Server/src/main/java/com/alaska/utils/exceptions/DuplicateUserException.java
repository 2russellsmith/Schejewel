package com.alaska.utils.exceptions;

public class DuplicateUserException extends RuntimeException{
    public DuplicateUserException() {
        super("The email address provided is not unique.");
    }
}
