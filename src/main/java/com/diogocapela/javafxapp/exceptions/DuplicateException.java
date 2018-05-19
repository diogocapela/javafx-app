package com.diogocapela.javafxapp.exceptions;

public class DuplicateException extends Exception {

    public DuplicateException(String message) {
        super("DuplicateException: " + message);
    }

}