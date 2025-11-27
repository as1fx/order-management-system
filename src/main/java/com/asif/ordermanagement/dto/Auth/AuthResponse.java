package com.asif.ordermanagement.dto.Auth;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String message;
}
