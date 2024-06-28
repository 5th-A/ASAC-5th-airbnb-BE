package org.example.airbnb.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum FacilityException implements CustomException{

    FACILITY_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "편의시설이 없습니다.", "Facility 테이블 내 id가 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
    private final String serverMessage;
    @Override
    public HttpStatus status() {
        return this.httpStatus;
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
