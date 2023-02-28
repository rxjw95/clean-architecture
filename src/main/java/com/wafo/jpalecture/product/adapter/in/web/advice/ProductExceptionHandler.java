package com.wafo.jpalecture.product.adapter.in.web.advice;

import com.wafo.jpalecture.exeption.IllegalProductCountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"com.wafo.jpalecture.product"})
public class ProductExceptionHandler {

    @ExceptionHandler(IllegalProductCountException.class)
    public ResponseEntity illegalProductCountExceptionHandler(Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
