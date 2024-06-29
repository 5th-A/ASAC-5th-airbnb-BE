package org.example.airbnb.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
public enum UserException implements CustomException{
    USER_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "해당 유저는 없습니다", "USER 테이블 내 해당하는 USER_ID가 없습니다.");

    private final HttpStatus status;
    private final String message;
    private final String serverMessage;

    @Override
    public HttpStatus status() {
        return this.status;
    }

    @Override
    public String message() {
        return this.message;
    }

    @Override
    public String serverMessage() {
        return this.serverMessage;
    }
}
