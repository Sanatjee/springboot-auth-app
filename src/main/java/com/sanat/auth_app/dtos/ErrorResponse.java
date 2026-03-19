package com.sanat.auth_app.dtos;

import org.springframework.http.HttpStatus;

public record ErrorResponse(
        String message,
        HttpStatus status,
        String error
) {
}
