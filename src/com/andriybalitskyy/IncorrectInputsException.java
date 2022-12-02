package com.andriybalitskyy;

public class IncorrectInputsException extends Exception {
    public IncorrectInputsException(String errorMessage) {
        super(errorMessage);
    }
}