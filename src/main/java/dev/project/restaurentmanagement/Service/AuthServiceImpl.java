package dev.project.restaurentmanagement.Service;

import dev.project.restaurentmanagement.Dto.SignUpRequest;
import dev.project.restaurentmanagement.Dto.UserDto;
import dev.project.restaurentmanagement.Entity.User;
import dev.project.restaurentmanagement.Enums.Role;
import dev.project.restaurentmanagement.Repository.UserRepository;
import dev.project.restaurentmanagement.Service.BaseService.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDto createUser(SignUpRequest signUpRequest) {
        User user = User.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()))
                .phoneNumber(signUpRequest.getPhoneNumber())
                .role(Role.USER)
                .build();
        User createdUser = userRepository.save(user);
        return UserDto.builder()
                .id(createdUser.getId())
                .name(createdUser.getName())
                .email(createdUser.getEmail())
                .password(createdUser.getPassword())
                .phoneNumber(createdUser.getPhoneNumber())
                .role(Role.USER)
                .build();
    }
}
