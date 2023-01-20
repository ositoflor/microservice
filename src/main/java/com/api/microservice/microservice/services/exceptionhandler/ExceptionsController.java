package com.api.microservice.microservice.services.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity handlerArray(ArrayIndexOutOfBoundsException e) {
        MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Token não informado");
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity handlerFeign(HttpClientErrorException e) {
        MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "E-mail ou senha inválido.");
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
}
