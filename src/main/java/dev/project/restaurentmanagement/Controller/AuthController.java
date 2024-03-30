package dev.project.restaurentmanagement.Controller;

import dev.project.restaurentmanagement.Configurations.JwtUtil;
import dev.project.restaurentmanagement.Controller.Router.AuthRouter;
import dev.project.restaurentmanagement.Dto.AuthRequest;
import dev.project.restaurentmanagement.Dto.AuthResponse;
import dev.project.restaurentmanagement.Dto.SignUpRequest;
import dev.project.restaurentmanagement.Dto.UserDto;
import dev.project.restaurentmanagement.Entity.User;
import dev.project.restaurentmanagement.Repository.UserRepository;
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
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class AuthController implements AuthRouter {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, UserRepository userRepository, JwtUtil jwtUtil){
        this.authService=authService;
        this.authenticationManager=authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
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

    @Override
    public AuthResponse createAuthToken(AuthRequest authRequest, HttpServletResponse res) throws IOException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
        } catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect credentials");
        } catch (DisabledException disabledException){
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        Optional<User> optUser = userRepository.findByEmail(userDetails.getUsername());
        AuthResponse authResponse = new AuthResponse();
        if(optUser.isPresent()){
            authResponse.setJwt(jwt);
            authResponse.setName(optUser.get().getName());
            authResponse.setRole(optUser.get().getRole());
            authResponse.setId(optUser.get().getId());
        }
        return authResponse;
    }
}
