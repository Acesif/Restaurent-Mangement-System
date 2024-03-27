package dev.project.restaurentmanagement.Controller.Router;

import dev.project.restaurentmanagement.Dto.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthRouter {

    @PostMapping("/signup")
    ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest);
}
