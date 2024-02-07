package com.school.schoolproject.exceptions;

import com.school.schoolproject.responses.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }


    @ExceptionHandler
    public ResponseEntity<Object> handleTeacherNotFoundEx(TeacherNotFoundEx teacherNotFoundEx){
        return ResponseHandler.generateResponse(404, teacherNotFoundEx.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<Object> handleStudentNotFound(StudentNotFoundEx studentNotFoundEx){
        return ResponseHandler.generateResponse(404, studentNotFoundEx.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<Object> handleCourseNotFound(CourseNotFoundEx courseNotFoundEx){
        return ResponseHandler.generateResponse(404, courseNotFoundEx.getMessage());
    }
}
