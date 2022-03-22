package com.cavalieri.BanckDemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionalHandler {

    @ExceptionHandler(ResourceNotFondException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFondException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setError("Resource not found");
        error.setInstant(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EntityNotHaveFoundsException.class)
    public ResponseEntity<StandardError> entityNotHaveFoundException(EntityNotHaveFoundsException e, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setError("Entity don't have founds");
        error.setInstant(Instant.now());
        error.setStatus(HttpStatus.FORBIDDEN.value());
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
