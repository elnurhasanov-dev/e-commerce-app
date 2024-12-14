package com.example.order.client.decoder;

import com.example.order.exceptions.BusinessException;
import com.example.order.exceptions.GenericFeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 404) {
            return new BusinessException("Customer not found in Customer MS");
        }
        return new GenericFeignException("Generic error occurred: " + response.reason());
    }
}