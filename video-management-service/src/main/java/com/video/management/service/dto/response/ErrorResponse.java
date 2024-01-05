package com.video.management.service.dto.response;

import lombok.Getter;

@Getter
public class ErrorResponse extends MessageResponse{
    private final String code;

    private ErrorResponse(String code, String message) {
        super(message);
        this.code = code;
    }

    public static ErrorResponse create(String code, String message) {
        return new ErrorResponse(code, message);
    };
}
