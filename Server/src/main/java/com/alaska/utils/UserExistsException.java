package com.alaska.utils;

public class UserExistsException extends Exception{
    public UserExistsException() {
        super("A user with this email already exists in the database.");
    }
}
