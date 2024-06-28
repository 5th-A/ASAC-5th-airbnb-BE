package org.example.airbnb.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum RoomException implements CustomException{


    ROOM_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "찾을 수 없는 방입니다.", "DB에 저장된 룸이 없습니다(SERVER)");

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
