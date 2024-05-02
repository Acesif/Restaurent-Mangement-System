package dev.project.restaurantmanagement.Controller;

import dev.project.restaurantmanagement.Controller.Router.AuthRouter;
import dev.project.restaurantmanagement.Dto.SignUpRequest;
import dev.project.restaurantmanagement.Dto.UserDto;
import dev.project.restaurantmanagement.Service.BaseService.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class AuthController implements AuthRouter {

    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @Override
    public ResponseEntity<?> signUpUser(SignUpRequest signUpRequest) {
        UserDto createdUserDto = authService.createUser(signUpRequest);

        if(createdUserDto == null){
            return new ResponseEntity<>("User creation failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> signUpAdmin(SignUpRequest signUpRequest) {
        UserDto createdAdminDto = authService.createAdmin(signUpRequest);

        if(createdAdminDto == null){
            return new ResponseEntity<>("Admin creation failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdAdminDto,HttpStatus.CREATED);
    }
}
