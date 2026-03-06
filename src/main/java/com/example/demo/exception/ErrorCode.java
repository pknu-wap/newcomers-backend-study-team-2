package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    INVALID_REQUEST(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "잘못된 요청입니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), "게시물을 찾을 수 없습니다."),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 오류");

    private final HttpStatus status;
    private final int code;
    private final String message;

    ErrorCode(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}