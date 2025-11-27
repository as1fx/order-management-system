package com.asif.ordermanagement.service.Role;

import com.asif.ordermanagement.entity.Role;
import com.asif.ordermanagement.exception.ResourceNotFoundException;
import com.asif.ordermanagement.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
