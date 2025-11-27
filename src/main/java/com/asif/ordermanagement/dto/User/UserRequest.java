package com.asif.ordermanagement.dto.User;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private Integer roleId;
}
