package org.example.airbnb.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum CategoryException implements CustomException{
    CATEGORY_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "존재하지 않는 카테고리 입니다.","(server error)카테고리 리스트가 db에 존재하지 않습니다.");

    private final HttpStatus status;
    private final String message;
    private final String serverMessage;

    @Override
    public HttpStatus status() {return this.status;}

    @Override
    public String message() {return this.message;}

    @Override
    public String serverMessage() {return this.serverMessage;}
}
