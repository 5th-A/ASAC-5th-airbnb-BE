package org.example.airbnb.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomAdvice{
    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity customRuntimeExceptionHandler(CustomRuntimeException e){
        log.error(e.getCustomException().serverMessage());
        return e.sendError();
    }
}
