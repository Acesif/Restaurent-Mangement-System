package dev.project.restaurentmanagement.Service.BaseService;

import dev.project.restaurentmanagement.Dto.SignUpRequest;
import dev.project.restaurentmanagement.Dto.UserDto;

public interface AuthService {
    UserDto createUser(SignUpRequest signUpRequest);
}
