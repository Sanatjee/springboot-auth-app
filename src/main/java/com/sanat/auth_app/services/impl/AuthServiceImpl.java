package com.sanat.auth_app.services.impl;

import com.sanat.auth_app.dtos.UserDto;
import com.sanat.auth_app.services.AuthService;
import com.sanat.auth_app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto registerUser(UserDto userDtoRequest) {
        //Encoding the password
        userDtoRequest.setPassword(passwordEncoder.encode(userDtoRequest.getPassword()));
        return userService.createUser(userDtoRequest);
    }
}
