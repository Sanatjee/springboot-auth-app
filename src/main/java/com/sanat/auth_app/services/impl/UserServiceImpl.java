package com.sanat.auth_app.services.impl;

import com.sanat.auth_app.dtos.UserDto;
import com.sanat.auth_app.entities.Role;
import com.sanat.auth_app.entities.User;
import com.sanat.auth_app.entities.enums.Provider;
import com.sanat.auth_app.exceptions.ResourceNotFoundException;
import com.sanat.auth_app.helpers.UserHelper;
import com.sanat.auth_app.repositories.UserRepository;
import com.sanat.auth_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        //Validations to be done
        User user = modelMapper.map(userDto,User.class);

        user.setProvider(userDto.getProvider() != null ? userDto.getProvider() : Provider.LOCAL);

        //Role Assignment to be done
        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public Iterable<UserDto> getUsers(){
        return userRepository.findAll().stream().map(user -> modelMapper.map(user,UserDto.class)).toList();
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).
                orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto getUserById(String userId) {
        UUID uid = UserHelper.UUIDParser(userId);
        User user = userRepository.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return modelMapper.map(user,UserDto.class);
    }


    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        //To Do : Validations to be updated
        UUID uid = UserHelper.UUIDParser(userId);
        User existingUser = userRepository.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        existingUser.setName(userDto.getName());
        existingUser.setPassword(userDto.getPassword());
        existingUser.setImage(userDto.getImage());
        User user = userRepository.save(existingUser);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public void deleteUser(String userId) {
        UUID uid = UserHelper.UUIDParser(userId);
        User user = userRepository.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }

}
