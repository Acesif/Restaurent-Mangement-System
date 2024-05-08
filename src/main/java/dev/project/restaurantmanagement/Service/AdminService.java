package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import dev.project.restaurantmanagement.Dto.FoodDto;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Dto.UserDto;
import dev.project.restaurantmanagement.Entity.Category;
import dev.project.restaurantmanagement.Entity.Food;
import dev.project.restaurantmanagement.Entity.User;
import dev.project.restaurantmanagement.Repository.CategoryRepository;
import dev.project.restaurantmanagement.Repository.FoodRepository;
import dev.project.restaurantmanagement.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    Response<UserDto> updateUser(UserDto userDto){
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
    Response<UserDto> getUserById(Integer id){

    }

    Response<List<UserDto>> getAllUsers(){

    }

    Response<Void> deleteUser(Integer id){

    }
}
