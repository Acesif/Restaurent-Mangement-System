package dev.project.restaurantmanagement.Controller;

import dev.project.restaurantmanagement.Controller.Router.AuthRouter;
import dev.project.restaurantmanagement.Dto.AuthResponse;
import dev.project.restaurantmanagement.Dto.LoginRequest;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Dto.UserDto;
import dev.project.restaurantmanagement.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController implements AuthRouter {

    private final AuthService authService;

    @Override
    public ResponseEntity<?> check() {
        return new ResponseEntity<>("hehe",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> signUpUser(UserDto registerRequest) {
        Response createdUserDto = authService.registerUser(registerRequest);
        return new ResponseEntity<>(createdUserDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        Response login = authService.authenticate(loginRequest);
        return new ResponseEntity<>(login,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> signUpAdmin(UserDto registerRequest) {
        Response createdAdminDto = authService.registerAdmin(registerRequest);
        return new ResponseEntity<>(createdAdminDto,HttpStatus.OK);
    }
}
