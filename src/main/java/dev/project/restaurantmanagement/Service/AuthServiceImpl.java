package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Dto.SignUpRequest;
import dev.project.restaurantmanagement.Dto.UserDto;
import dev.project.restaurantmanagement.Entity.User;
import dev.project.restaurantmanagement.Enums.Role;
import dev.project.restaurantmanagement.Repository.UserRepository;
import dev.project.restaurantmanagement.Service.BaseService.AuthService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDto createUser(SignUpRequest signUpRequest) {
        User user = User.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
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

    @Override
    public UserDto createAdmin(SignUpRequest signUpRequest) {
        User admin = User.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .role(Role.ADMIN)
                .build();
        User createdAdmin = userRepository.save(admin);
        return UserDto.builder()
                .id(createdAdmin.getId())
                .name(createdAdmin.getName())
                .email(createdAdmin.getEmail())
                .password(createdAdmin.getPassword())
                .phoneNumber(createdAdmin.getPhoneNumber())
                .role(Role.ADMIN)
                .build();
    }
    @PostConstruct
    public UserDto createAdminUser() {
        User admin = userRepository.findByEmail("admin@rest.com");
        userRepository.delete(admin);
        User adminUser = User.builder()
                .name("admin")
                .email("admin@rest.com")
                .password("admin123456")
                .phoneNumber("00000000000")
                .role(Role.ADMIN)
                .build();
        User createdAdmin = userRepository.save(adminUser);
        return UserDto.builder()
                .id(createdAdmin.getId())
                .name(createdAdmin.getName())
                .email(createdAdmin.getEmail())
                .password(createdAdmin.getPassword())
                .phoneNumber(createdAdmin.getPhoneNumber())
                .role(Role.ADMIN)
                .build();
    }
}
