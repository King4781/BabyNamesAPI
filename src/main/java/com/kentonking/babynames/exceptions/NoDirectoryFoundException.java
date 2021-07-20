package com.kentonking.babynames.exceptions;

public class NoDirectoryFoundException extends RuntimeException {
    public NoDirectoryFoundException(String message) {
        super(message);
    }
}
