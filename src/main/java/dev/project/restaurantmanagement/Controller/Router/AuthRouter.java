package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.LoginRequest;
import dev.project.restaurantmanagement.Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthRouter {

    @GetMapping("/")
    ResponseEntity<?> check();

    @PostMapping("/register")
    ResponseEntity<?> signUpUser(@RequestBody UserDto registerRequest);

    @PostMapping("/login")
    ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest);
    @PostMapping("/admin")
    ResponseEntity<?> signUpAdmin(@RequestBody UserDto registerRequest);
}
