package com.asif.ordermanagement.mapper.User;

import com.asif.ordermanagement.dto.Admin.AdminResponse;
import com.asif.ordermanagement.dto.User.UserResponse;
import com.asif.ordermanagement.entity.User;

public class UserMapper {
    public static UserResponse toUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setRoleId(user.getRole().getId());
        return userResponse;
    }

    public static AdminResponse toAdminResponse(User user){
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setId(user.getId());
        adminResponse.setName(user.getName());
        adminResponse.setEmail(user.getEmail());
        return adminResponse;
    }
}
