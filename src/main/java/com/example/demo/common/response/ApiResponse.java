package com.example.demo.common.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {

    private boolean success;
    private int code;
    private String message;
    private T data;
}
