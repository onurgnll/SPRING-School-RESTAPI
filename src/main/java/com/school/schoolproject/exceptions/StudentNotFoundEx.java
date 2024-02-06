package com.school.schoolproject.exceptions;

public class StudentNotFoundEx extends RuntimeException{
    public StudentNotFoundEx(String message) {
        super(message);
    }
}
