package com.sanat.auth_app.services;

import com.sanat.auth_app.dtos.UserDto;

public interface AuthService {
    UserDto registerUser(UserDto userDto);
}
