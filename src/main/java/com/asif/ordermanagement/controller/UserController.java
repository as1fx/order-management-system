package com.asif.ordermanagement.controller;

import com.asif.ordermanagement.dto.User.UserResponse;
import com.asif.ordermanagement.service.User.UserService;
import com.asif.ordermanagement.service.User.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer id) {
        UserResponse user = userService.getUserResponseById(id);
        return ResponseEntity.ok(user);
    }
}
