package org.example.airbnb.exception;

import org.springframework.http.HttpStatus;

public interface CustomException {
    HttpStatus status();
    String message();
    String serverMessage();
}
