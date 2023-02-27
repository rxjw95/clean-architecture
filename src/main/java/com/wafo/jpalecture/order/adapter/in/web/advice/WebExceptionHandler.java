package com.wafo.jpalecture.order.adapter.in.web.advice;

import com.wafo.jpalecture.order.exeption.IllegalProductCountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(IllegalProductCountException.class)
    public ResponseEntity illegalProductCountExceptionHandler(Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
