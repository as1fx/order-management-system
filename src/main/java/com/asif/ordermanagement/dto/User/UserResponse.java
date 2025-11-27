package com.asif.ordermanagement.dto.User;

import lombok.Data;

@Data
public class UserResponse {
    private Integer id;
    private String name;
    private String email;
    private Integer roleId;
}
