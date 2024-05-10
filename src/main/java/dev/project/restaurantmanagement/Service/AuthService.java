package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Config.JwtService;
import dev.project.restaurantmanagement.Dto.AuthResponse;
import dev.project.restaurantmanagement.Dto.LoginRequest;
import dev.project.restaurantmanagement.Dto.Response;
import dev.project.restaurantmanagement.Dto.UserDto;
import dev.project.restaurantmanagement.Entity.User;
import dev.project.restaurantmanagement.Entity.Role;
import dev.project.restaurantmanagement.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public Response<AuthResponse> registerUser(UserDto registerRequest) {
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            return Response.<AuthResponse>builder()
                    .isSuccess(false)
                    .code(400)
                    .message("User already exists")
                    .build();
        }
        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(Role.CUSTOMER)
                .build();
        User createdUser = userRepository.save(user);

        String token = jwtService.generateToken(createdUser);

        return Response.<AuthResponse>builder()
                .isSuccess(true)
                .code(201)
                .message("User created successfully")
                .values(AuthResponse.builder()
                        .email(createdUser.getEmail())
                        .role(createdUser.getRole())
                        .token(token)
                        .build())
                .build();
    }

    public Response<UserDto> updatePassword(UserDto userDto){
        User user = userRepository.findById(userDto.getId()).orElseThrow();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return Response.<UserDto>builder()
                .isSuccess(true)
                .code(200)
                .message("Password successfully updated")
                .values(UserDto.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .name(user.getName())
                        .role(user.getRole())
                        .phoneNumber(user.getPhoneNumber())
                        .build())
                .build();
    }

    public Response<AuthResponse> authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(user.isPresent()){
            String token = jwtService.generateToken(user.get());
            return Response.<AuthResponse>builder()
                    .isSuccess(true)
                    .code(200)
                    .message("Logged in successfully")
                    .values(AuthResponse.builder()
                            .email(user.get().getEmail())
                            .role(user.get().getRole())
                            .token(token)
                            .build())
                    .build();
        }
        return Response.<AuthResponse>builder()
                .isSuccess(false)
                .code(400)
                .message("User not found")
                .build();
    }

    @PostConstruct
    public void createAdminUser() {
        Optional<User> admin = userRepository.findByEmail("admin@restaurent.com");
        admin.ifPresent(userRepository::delete);
        User adminUser = User.builder()
                .name("admin")
                .email("admin@restaurent.com")
                .password(passwordEncoder.encode("admin123456"))
                .phoneNumber("00000000000")
                .role(Role.ADMIN)
                .build();
        userRepository.save(adminUser);
    }
}
