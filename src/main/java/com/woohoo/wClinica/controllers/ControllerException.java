package com.woohoo.wClinica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.woohoo.wClinica.models.handler.ErrorHandler;

@RestControllerAdvice
public class ControllerException {
    
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorHandler> handle(MethodArgumentNotValidException exception) {
        
        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();

        List<ErrorHandler> list = new ArrayList<>();

        fieldErrorList.forEach(error -> {
            list.add(new ErrorHandler(error.getField(), error.getDefaultMessage()));
        });
        
        return list;
    }
}
