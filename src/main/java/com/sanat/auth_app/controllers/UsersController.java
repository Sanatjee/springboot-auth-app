package com.sanat.auth_app.controllers;

import com.sanat.auth_app.dtos.UserDto;
import com.sanat.auth_app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping
    @RequestMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @GetMapping
    @RequestMapping("/id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping
    @RequestMapping("/userId/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") String userId){
        return ResponseEntity.ok(userService.updateUser(userDto,userId));
    }

}
