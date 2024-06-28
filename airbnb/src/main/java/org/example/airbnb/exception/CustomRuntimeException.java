package org.example.airbnb.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class CustomRuntimeException extends RuntimeException{
    private static final String STATUS = "STATUS";
    private static final String MESSAGE = "MESSAGE";

    private final CustomException customException;

    public ResponseEntity<Map<String, String>> sendError() {
        Map<String, String> messages = new LinkedHashMap<>();
        messages.put(STATUS, customException.status().toString());
        messages.put(MESSAGE, customException.message());
        return ResponseEntity.status(customException.status()).body(messages);
    }
}
