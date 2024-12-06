package com.example.product.exception;

import com.example.product.dto.response.ErrorResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ProductPurchaseException.class)
    public String handle(ProductPurchaseException exp) {
        return exp.getMessage();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    public String handle(NotFoundException exp) {
        return exp.getMessage();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return new ErrorResponse(errors);
    }
}
