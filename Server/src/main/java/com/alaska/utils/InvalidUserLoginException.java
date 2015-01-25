package com.alaska.utils;

public class InvalidUserLoginException extends Exception {
    public InvalidUserLoginException() {
        super("The username or password was not correct");
    }
}
