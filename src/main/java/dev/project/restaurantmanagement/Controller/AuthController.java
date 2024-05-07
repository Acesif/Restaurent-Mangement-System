package dev.project.restaurantmanagement.Controller;

import dev.project.restaurantmanagement.Controller.Router.AuthRouter;
import dev.project.restaurantmanagement.Dto.AuthResponse;
import dev.project.restaurantmanagement.Dto.LoginRequest;
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
        return null;
    }

    @Override
    public ResponseEntity<?> signUpUser(UserDto registerRequest) {
        AuthResponse createdUserDto = authService.registerUser(registerRequest);

        if(createdUserDto == null){
            return new ResponseEntity<>("User creation failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        AuthResponse login = authService.authenticate(loginRequest);

        if(login == null){
            return new ResponseEntity<>("Login Failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(login,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> signUpAdmin(UserDto registerRequest) {
        AuthResponse createdAdminDto = authService.registerAdmin(registerRequest);

        if(createdAdminDto == null){
            return new ResponseEntity<>("Admin creation failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdAdminDto,HttpStatus.CREATED);
    }
}
