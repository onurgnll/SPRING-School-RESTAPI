package com.school.schoolproject.exceptions;

public class TeacherNotFoundEx extends RuntimeException{

    public TeacherNotFoundEx(String message) {
        super(message);
    }

    public TeacherNotFoundEx(String message, Throwable cause) {
        super(message, cause);
    }
}
