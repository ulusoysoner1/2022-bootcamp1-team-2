package com.example.Myrecipes.Exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}
