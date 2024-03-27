package dev.project.restaurentmanagement.Controller;

import dev.project.restaurentmanagement.Controller.Router.AuthRouter;
import dev.project.restaurentmanagement.Dto.SignUpRequest;
import dev.project.restaurentmanagement.Dto.UserDto;
import dev.project.restaurentmanagement.Service.BaseService.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
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
}
