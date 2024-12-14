package com.example.order.client.decoder;

import com.example.order.exceptions.GenericFeignException;
import com.example.order.exceptions.NotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


import java.io.InputStream;


@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    @SneakyThrows
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message  = null;
        InputStream bodyIs = response.body().asInputStream();
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ExceptionMessage.class);

        if (response.status() == 404) {
//            return new NotFoundException("Client Not Found Exception");
            return new NotFoundException(message.getMessage() != null ? message.getMessage() : "Not Found");
        }
        return new GenericFeignException("Generic error occurred: " + response.reason());
    }
}