package com.school.schoolproject.exceptions;

public class NotValidException extends RuntimeException{
    public NotValidException(String message) {
        super(message);
    }
}
