package dev.project.restaurentmanagement.Controller.Router;

import dev.project.restaurentmanagement.Dto.AuthRequest;
import dev.project.restaurentmanagement.Dto.AuthResponse;
import dev.project.restaurentmanagement.Dto.SignUpRequest;
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


    @PostMapping("/login")
    AuthResponse createAuthToken(@RequestBody AuthRequest authRequest, HttpServletResponse res) throws IOException;
}
