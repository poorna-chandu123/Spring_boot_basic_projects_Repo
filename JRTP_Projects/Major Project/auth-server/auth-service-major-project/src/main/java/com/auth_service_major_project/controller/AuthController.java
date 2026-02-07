package com.auth_service_major_project.controller;

import com.auth_service_major_project.dto.LoginRequest;
import com.auth_service_major_project.dto.LoginResponse;
import com.auth_service_major_project.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// Base URL for authentication APIs
@RequestMapping("/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Login API
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        log.info("Login API hit for user: {}", request.getUsername());

        // Delegate login to service layer
        return ResponseEntity.ok(
                authService.login(request)
        );
    }


    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Auth service JWT working!");
    }
}
