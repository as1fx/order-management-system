package com.asif.ordermanagement.service.Auth;

import com.asif.ordermanagement.dto.User.UserRequest;
import com.asif.ordermanagement.dto.User.UserResponse;
import org.apache.coyote.BadRequestException;

public interface AuthService {
    UserResponse register(UserRequest request) throws BadRequestException;
    String login(String email, String password) throws BadRequestException;
}
