package dev.project.restaurantmanagement.Dto;

import dev.project.restaurantmanagement.Entity.Role;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String email;
    private String token;
    private Role role;
}
