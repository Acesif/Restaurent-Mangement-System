package dev.project.restaurantmanagement.Dto;

import dev.project.restaurantmanagement.Entity.Role;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Component

public class UserDto {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;

}
