package com.example.myapplication.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
    private ErrorResponse error;
    private T data;
    private Boolean success;

    public ErrorResponse getError() {
        return error;
    }

    public T getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }
}
