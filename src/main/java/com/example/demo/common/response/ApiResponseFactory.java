package com.example.demo.common.response;

import com.example.demo.exception.ErrorCode;

public class ApiResponseFactory {

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .code(200)
                .message("요청 성공")
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .code(200)
                .message(message)
                .data(data)
                .build();
    }

    public static ApiResponse<?> fail(ErrorCode errorCode) {
        return ApiResponse.builder()
                .success(false)
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .data(null)
                .build();
    }
}