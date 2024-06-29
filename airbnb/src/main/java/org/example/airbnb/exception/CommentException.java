package org.example.airbnb.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum CommentException implements CustomException{
    COMMENT_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "해당 룸에 해당하는 댓글이 없습니다.", "COMMENT 테이블 내 해당하는 ROOM_ID가 없습니다.");

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
