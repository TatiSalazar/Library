package com.universal.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AvailableBookException extends Exception {
    public AvailableBookException(String message){
        super(message);
    }
}
