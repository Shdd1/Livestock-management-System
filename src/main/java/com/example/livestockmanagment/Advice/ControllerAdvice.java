package com.example.livestockmanagment.Advice;

import com.example.livestockmanagment.Api.ApiExeption;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    //ApiExeption
    @ExceptionHandler(value =ApiExeption.class)
    public ResponseEntity ApiExeption(ApiExeption e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    //JSON error
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    // trying to access a part of something that doesn't exist
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity NullPointerException(NullPointerException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    //path No static resource
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String message = e.getMessage();
        return ResponseEntity.status(404).body(message);
    }
    //Validation
    @ExceptionHandler(value = MethodArgumentNotValidException.class )
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
       String message = e.getMessage();
        return ResponseEntity.status(404).body(message);
    }
    //Method Not Allowed
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        String message = e.getMessage();
        return ResponseEntity.status(405).body(message);
    }
    //duplicate entry
    @ExceptionHandler(value = DataIntegrityViolationException.class )
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    //if entering Wrong date in path like when using LocalDate type if  enter 2024-02
    @ExceptionHandler(value =MethodArgumentTypeMismatchException.class )
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }



}
