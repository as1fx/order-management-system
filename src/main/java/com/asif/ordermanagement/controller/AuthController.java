package com.asif.ordermanagement.controller;

import com.asif.ordermanagement.dto.Auth.AuthResponse;
import com.asif.ordermanagement.dto.Auth.LoginRequest;
import com.asif.ordermanagement.dto.User.UserRequest;
import com.asif.ordermanagement.dto.User.UserResponse;
import com.asif.ordermanagement.exception.BadRequestException;
import com.asif.ordermanagement.service.Auth.AuthService;
import com.asif.ordermanagement.service.Auth.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        try {
            UserResponse response = authService.register(userRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (org.apache.coyote.BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
            AuthResponse authResponse = new AuthResponse();
            authResponse.setToken(token);
            authResponse.setMessage("Login successful");
            return ResponseEntity.ok(authResponse);
        } catch (org.apache.coyote.BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
