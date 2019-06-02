package com.mcserby.training.exceptions;

public class ConversionFailedException extends Exception {
    public ConversionFailedException(Exception e) {
        super(e);
    }
}
