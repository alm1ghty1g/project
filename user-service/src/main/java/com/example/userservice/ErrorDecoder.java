package com.example.userservice;

import feign.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorDecoder implements feign.codec.ErrorDecoder {


    @Override
    public Exception decode(String method, Response response) {
        switch (response.status()) {
            case 400:
                // return new BadRequestException();
                break;
            case 500: {
                if (method.contains("findUser")) {
                    return new ResponseStatusException(HttpStatus.valueOf(response.status()), "User not found");
                }
                break;
            }
            default:
                return new Exception(response.reason());

        }

        return null;
    }
}
