package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.CategoryDto;
import dev.project.restaurantmanagement.Dto.FoodDto;
import dev.project.restaurantmanagement.Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

public interface AdminRouter {

    @PutMapping
    ResponseEntity<?> updateUser(@RequestBody UserDto userDto);

    @GetMapping("/{id}")
    ResponseEntity<?> getUserById(@PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable("id") Integer id);

    @PostMapping
    ResponseEntity<?> signUpEmployee(@RequestBody UserDto registerRequest);

    @GetMapping("/users")
    ResponseEntity<?> getAllUsers();

}
