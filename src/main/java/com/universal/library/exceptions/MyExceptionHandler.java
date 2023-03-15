package com.universal.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<?> handleExceptionStudent(StudentNotFoundException ex){

        return new ResponseEntity<>( ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserLibraryNotFoundException.class)
    public ResponseEntity<?> handleExceptionLibrary(UserLibraryNotFoundException ex){

        return new ResponseEntity<>( ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<?> handleExceptionBook(BookNotFoundException ex){

        return new ResponseEntity<>( ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AvailableBookException.class)
    public ResponseEntity<?> handleExceptionBook(AvailableBookException ex){

        return new ResponseEntity<>( ex.getMessage(),HttpStatus.NOT_FOUND);
    }
}
