package dev.project.restaurantmanagement.Service;

import dev.project.restaurantmanagement.Config.JwtService;
import dev.project.restaurantmanagement.Dto.AuthResponse;
import dev.project.restaurantmanagement.Dto.LoginRequest;
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

    public AuthResponse registerUser(UserDto registerRequest) {
        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(Role.USER)
                .build();
        User createdUser = userRepository.save(user);

        String token = jwtService.generateToken(createdUser);

        return AuthResponse.builder()
                .email(createdUser.getEmail())
                .role(createdUser.getRole())
                .token(token)
                .build();
    }

    public AuthResponse registerAdmin(UserDto registerRequest) {
        User admin = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(Role.ADMIN)
                .build();
        User createdAdmin = userRepository.save(admin);

        String token = jwtService.generateToken(createdAdmin);

        return AuthResponse.builder()
                .email(createdAdmin.getEmail())
                .role(createdAdmin.getRole())
                .token(token)
                .build();
    }

    public AuthResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(user.isPresent()){
            String token = jwtService.generateToken(user.get());
            return AuthResponse.builder()
                    .email(user.get().getEmail())
                    .role(user.get().getRole())
                    .token(token)
                    .build();
        }
        return null;
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
