package com.example.order.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ResponseStatus(BAD_REQUEST)
//    @ExceptionHandler({NotFoundException.class})
//    public ExceptionResponse handle(ProductPurchaseException ex, HttpServletRequest request) {
//        log.error("{}: {}", ex.getClass().getSimpleName(), ex.getMessage());
//
//        return ExceptionResponse.builder()
//                .statusCode(NOT_FOUND.value())
//                .message(ex.getMessage())
//                .error(NOT_FOUND.getReasonPhrase())
//                .path(request.getRequestURI())
//                .timestamp(LocalDateTime.now())
//                .build();
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handle(MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidException : " + ex);

        Map<String, String> map = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> map.put(error.getField(), error.getDefaultMessage()));

        return map;
    }
}
