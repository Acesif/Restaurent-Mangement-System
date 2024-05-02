package dev.project.restaurantmanagement.Controller.Router;

import dev.project.restaurantmanagement.Dto.AuthRequest;
import dev.project.restaurantmanagement.Dto.AuthResponse;
import dev.project.restaurantmanagement.Dto.SignUpRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public interface AuthRouter {

    @PostMapping("/signup")
    ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest);

    @PostMapping("/admin")
    ResponseEntity<?> signUpAdmin(@RequestBody SignUpRequest signUpRequest);
}
