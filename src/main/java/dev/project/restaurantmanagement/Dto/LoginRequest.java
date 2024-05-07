package dev.project.restaurantmanagement.Dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String email;
    private String password;
}
