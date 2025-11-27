package com.asif.ordermanagement.service.User;

import com.asif.ordermanagement.dto.User.UserRequest;
import com.asif.ordermanagement.dto.User.UserResponse;
import com.asif.ordermanagement.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserResponse createUser(UserRequest userRequest);
    User getUserByEmail(String email);
    User getUserById(Integer id);
    UserResponse getUserResponseById(Integer id);
}
