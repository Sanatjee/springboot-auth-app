package com.sanat.auth_app.dtos;

import com.sanat.auth_app.entities.Role;
import com.sanat.auth_app.entities.enums.Provider;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String image;
    private boolean isActive = true;
    private Provider provider = Provider.LOCAL;
    private Set<RoleDto> roles = new HashSet<>();
}
