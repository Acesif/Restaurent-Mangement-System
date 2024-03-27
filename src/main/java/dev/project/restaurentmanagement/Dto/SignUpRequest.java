package dev.project.restaurentmanagement.Dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
