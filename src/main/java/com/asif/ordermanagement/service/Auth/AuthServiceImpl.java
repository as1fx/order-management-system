package com.asif.ordermanagement.service.Auth;

import com.asif.ordermanagement.dto.User.UserRequest;
import com.asif.ordermanagement.dto.User.UserResponse;
import com.asif.ordermanagement.entity.Role;
import com.asif.ordermanagement.entity.User;
import com.asif.ordermanagement.mapper.User.UserMapper;
import com.asif.ordermanagement.repository.RoleRepository;
import com.asif.ordermanagement.repository.UserRepository;
import com.asif.ordermanagement.config.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public UserResponse register(UserRequest userRequest) throws BadRequestException {
        if(userRepository.findByEmail(userRequest.getEmail()).isPresent()){
            throw new BadRequestException("Email already is use");
        }

        Role role = roleRepository.findById(userRequest.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole(role);

        userRepository.save(user);
        return UserMapper.toUserResponse(user);
    }

    @Override
    public String login(String email, String password) throws BadRequestException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("Invalid email or password"));

        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new BadRequestException("Invalid email or password");
        }

        return jwtTokenProvider.createToken(user.getId(), String.valueOf(user.getRole()));
    }
}
