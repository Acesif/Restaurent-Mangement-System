package dev.project.restaurentmanagement.Dto;

import dev.project.restaurentmanagement.Enums.Role;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String jwt;
    private Role role;
    private Integer id;
    private String name;
}
