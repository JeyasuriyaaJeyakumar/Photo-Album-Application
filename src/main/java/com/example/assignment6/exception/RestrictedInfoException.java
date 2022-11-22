package com.example.assignment6.exception;

public class RestrictedInfoException extends Exception{

    public String getMessage() {
        return "Restricted user info !";
    }
}
