package com.sanat.auth_app.services;

import com.sanat.auth_app.dtos.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    Iterable getUsers();

    UserDto getUserByEmail(String email);

    UserDto getUserById(String userId);

    UserDto updateUser(UserDto userDto, String userId);

    void deleteUser(String userId);
}
