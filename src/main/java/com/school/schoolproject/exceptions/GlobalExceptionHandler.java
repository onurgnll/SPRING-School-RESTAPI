package com.school.schoolproject.exceptions;

import com.school.schoolproject.responses.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleGeneralException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }


    @ExceptionHandler
    public ResponseEntity<Object> handleNotFoundEx(NotFoundException notFoundException){
        return ResponseHandler.generateResponse(404, notFoundException.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<Object> handleNotValidEx(NotValidException notValidException){
        return ResponseHandler.generateResponse(400, notValidException.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<Object> handleAlreadyExist(AlreadyExistException alreadyExistException){
        return ResponseHandler.generateResponse(409, alreadyExistException.getMessage());
    }
}
