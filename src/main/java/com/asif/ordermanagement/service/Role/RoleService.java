package com.asif.ordermanagement.service.Role;

import com.asif.ordermanagement.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    Role create(Role role);
    Role getById(Integer id);
    List<Role> getAll();

}
