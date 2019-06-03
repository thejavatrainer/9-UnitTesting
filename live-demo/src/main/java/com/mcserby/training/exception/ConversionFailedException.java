package com.mcserby.training.exception;

public class ConversionFailedException extends Exception {
    public ConversionFailedException(Exception e) {
        super(e);
    }
}
