package com.example.order.exceptions;

public class GenericFeignException extends RuntimeException{

    public GenericFeignException(String message) {
        super(message);
    }
}
