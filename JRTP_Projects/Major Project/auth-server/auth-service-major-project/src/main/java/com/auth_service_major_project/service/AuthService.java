package com.auth_service_major_project.service;

import com.auth_service_major_project.controller.AuthController;
import com.auth_service_major_project.dto.LoginRequest;
import com.auth_service_major_project.dto.LoginResponse;
import com.auth_service_major_project.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Contains core authentication business logic
public class AuthService {
    private static final Logger log = LoggerFactory.getLogger(AuthService.class);


    // Spring Security authentication engine
    private final AuthenticationManager authenticationManager;

    // JWT generator utility
    private final JwtUtil jwtUtil;

    public AuthService(AuthenticationManager authenticationManager,
                       JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

/*    public LoginResponse login(LoginRequest request) {
        log.info("Authenticating user: {}", request.getUsername());

        Authentication authentication;
        try {
            // Authenticate using Spring Security
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            log.info("Authentication successful for user: {}", request.getUsername());

        } catch (AuthenticationException ex) {
            log.error("AUTH FAILED REASON >>> {}", ex.getClass().getName());
            log.error("AUTH FAILED MESSAGE >>> {}", ex.getMessage());
            throw ex; // you can also return custom error response if you want
        }

        try {
            // If authentication successful, get principal
            User user = (User) authentication.getPrincipal();

            // Extract roles
            List<String> roles = user.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();

            // Generate JWT
            String token = jwtUtil.generateToken(user.getUsername(), roles);

            log.info("JWT generated for user {}: {}", user.getUsername(), token);

            // Return token and expiry info
            return new LoginResponse(token, jwtUtil.getExpiration());

        } catch (Exception ex) {
            log.error("Error generating JWT: {}", ex.getMessage(), ex);
            throw new RuntimeException("Failed to generate JWT", ex);
        }
    }
}

 */

    public LoginResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        User user = (User) authentication.getPrincipal();

        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        String token = jwtUtil.generateToken(user.getUsername(), roles);

        return new LoginResponse(token, jwtUtil.getExpiration());
    }
}
