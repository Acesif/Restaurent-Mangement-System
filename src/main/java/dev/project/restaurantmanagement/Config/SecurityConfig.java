package dev.project.restaurantmanagement.Config;

import dev.project.restaurantmanagement.Entity.Role;
import dev.project.restaurantmanagement.Service.UserDetailsServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsServiceImp userDetailsService;
    private final JwtAuthFilter authFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req -> req
                                .requestMatchers("/api/v1/auth/login", "/api/v1/auth/register")
                                .permitAll()

                                .requestMatchers("/api/v1/admin/**")
                                .hasAuthority(Role.ADMIN.name())

                                .requestMatchers(HttpMethod.PUT,"/api/v1/admin/**")
                                .hasAuthority(Role.CUSTOMER.name())
                                .requestMatchers(HttpMethod.POST,"/api/v1/admin/order/**","/api/v1/reservation/**")
                                .hasAuthority(Role.CUSTOMER.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/admin/order/ordr_{code}","/api/v1/reservation/res_{code}")
                                .hasAuthority(Role.CUSTOMER.name())

                                .requestMatchers("/api/v1/auth/resetpass")
                                .hasAnyAuthority(Role.ADMIN.name(), Role.MANAGER.name(),Role.EMPLOYEE.name(),Role.CUSTOMER.name())

                                .requestMatchers("/api/v1/admin/category/**")
                                .hasAnyAuthority(Role.ADMIN.name(), Role.MANAGER.name())

                                .requestMatchers("/api/v1/admin/food/**")
                                .hasAnyAuthority(Role.ADMIN.name(), Role.MANAGER.name())

                                .requestMatchers("/api/v1/admin/order/**")
                                .hasAnyAuthority(Role.ADMIN.name(), Role.MANAGER.name(),Role.EMPLOYEE.name()
                                )
                                .anyRequest()
                                .authenticated()


                )
                .userDetailsService(userDetailsService)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
