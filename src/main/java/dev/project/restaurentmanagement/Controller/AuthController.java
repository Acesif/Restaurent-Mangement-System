package dev.project.restaurentmanagement.Controller;

import dev.project.restaurentmanagement.Controller.Router.AuthRouter;
import dev.project.restaurentmanagement.Dto.AuthRequest;
import dev.project.restaurentmanagement.Dto.AuthResponse;
import dev.project.restaurentmanagement.Dto.SignUpRequest;
import dev.project.restaurentmanagement.Dto.UserDto;
import dev.project.restaurentmanagement.Service.BaseService.AuthService;
import dev.project.restaurentmanagement.Service.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
public class AuthController implements AuthRouter {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService){
        this.authService=authService;
        this.authenticationManager=authenticationManager;
        this.userDetailsService = userDetailsService;
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
    public AuthResponse createAuthToken(AuthRequest authRequest, HttpServletResponse res) throws IOException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
        } catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect credentialls");
        } catch (DisabledException disabledException){
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        return null;
    }
}
