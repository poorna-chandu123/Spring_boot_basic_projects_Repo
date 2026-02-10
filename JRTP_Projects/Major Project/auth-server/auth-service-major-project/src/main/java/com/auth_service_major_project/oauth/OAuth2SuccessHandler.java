package com.auth_service_major_project.oauth;

import com.auth_service_major_project.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
// Called automatically after successful GitHub login
public class OAuth2SuccessHandler
        implements AuthenticationSuccessHandler {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException {

        // Get GitHub user details

        OAuth2User user = (OAuth2User) authentication.getPrincipal();

        // GitHub username
        String username = user.getAttribute("login");
        String email    = user.getAttribute("email");

        if (email == null) {
            email = username + "@github.local";
        }

        // Check if user already exists
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM users WHERE username = ?",
                Integer.class,
                username
        );

        // Insert if the user first time login means
        if (count != null && count == 0) {
            jdbcTemplate.update(
                    "INSERT INTO users(username, password, is_active, role_id,email) " +
                            "VALUES (?, ?, ?, ?,?)",
                    username,
                    "OAUTH_USER",
                    "Y",
                    2   ,
                    email// FK to roles table
            );
        }

        // Fetch role name for JWT
        String role = jdbcTemplate.queryForObject(
                "SELECT r.role_name " +
                        "FROM users u JOIN roles r ON u.role_id = r.role_id " +
                        "WHERE u.username = ?",
                String.class,
                username
        );

        // Generate JWT using DB role
        String token = jwtUtil.generateToken(
                username,
                List.of(role)
        );

        response.setContentType("application/json");
        response.getWriter().write("{\"token\":\"" + token + "\"}");
    }
}