package com.kentonking.babynames.exceptions;

public class BabyNotFoundException extends RuntimeException {
    public BabyNotFoundException(String message) {
        super(message);
    }
}
