package dev.project.restaurantmanagement.Service.BaseService;

import dev.project.restaurantmanagement.Dto.SignUpRequest;
import dev.project.restaurantmanagement.Dto.UserDto;

public interface AuthService {
    UserDto createUser(SignUpRequest signUpRequest);
    UserDto createAdmin(SignUpRequest signUpRequest);
}
