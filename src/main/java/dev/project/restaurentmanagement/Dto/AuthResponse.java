package dev.project.restaurentmanagement.Dto;

import dev.project.restaurentmanagement.Enums.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String jwt;
    private Role role;
    private Integer id;
    private String name;
}
