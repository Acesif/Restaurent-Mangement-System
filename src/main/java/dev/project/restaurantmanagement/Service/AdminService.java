package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Config.JwtService;
import dev.project.restaurantmanagement.Dto.*;
import dev.project.restaurantmanagement.Entity.Category;
import dev.project.restaurantmanagement.Entity.Food;
import dev.project.restaurantmanagement.Entity.User;
import dev.project.restaurantmanagement.Repository.CategoryRepository;
import dev.project.restaurantmanagement.Repository.FoodRepository;
import dev.project.restaurantmanagement.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public Response<UserDto> updateUser(UserDto userDto){
        User user = userRepository.findById(userDto.getId()).orElseThrow();
        user.setName(user.getName());
        user.setRole(userDto.getRole());
        user.setEmail(user.getEmail());
        user.setPhoneNumber(user.getPhoneNumber());

        return Response.<UserDto>builder()
                .isSuccess(true)
                .code(201)
                .message("User successfully updated")
                .values(UserDto.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .name(user.getEmail())
                        .role(user.getRole())
                        .phoneNumber(user.getPhoneNumber())
                        .build())
                .build();
    }
    public Response<UserDto> getUserById(Integer id){
        User user = userRepository.findById(id).orElseThrow();

        return Response.<UserDto>builder()
                .isSuccess(true)
                .code(200)
                .message("User successfully fetched")
                .values(UserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .phoneNumber(user.getPhoneNumber())
                        .build())
                .build();
    }

    public Response<List<UserDto>> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return Response.<List<UserDto>>builder()
                .isSuccess(true)
                .code(200)
                .message("Users successfully fetched")
                .values(userList.stream().map(User::getUserDto).collect(Collectors.toList()))
                .build();
    }

    public Response<AuthResponse> registerEmployee(UserDto registerRequest) {
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            return Response.<AuthResponse>builder()
                    .isSuccess(false)
                    .code(400)
                    .message("Employee already exists")
                    .build();
        }
        User staff = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(registerRequest.getRole())
                .build();
        User createdAdmin = userRepository.save(staff);

        String token = jwtService.generateToken(createdAdmin);

        return Response.<AuthResponse>builder()
                .isSuccess(true)
                .code(201)
                .message(createdAdmin.getRole()+" created successfully")
                .values(AuthResponse.builder()
                        .email(createdAdmin.getEmail())
                        .role(createdAdmin.getRole())
                        .token(token)
                        .build())
                .build();
    }

    public Response<Void> deleteUser(Integer id){
        userRepository.deleteById(id);

        return Response.<Void>builder()
                .isSuccess(true)
                .code(200)
                .message("User successfully deleted")
                .values(null)
                .build();
    }
}
