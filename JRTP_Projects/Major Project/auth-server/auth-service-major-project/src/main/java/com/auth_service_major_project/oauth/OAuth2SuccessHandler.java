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
        OAuth2User user =
                (OAuth2User) authentication.getPrincipal();

        // GitHub username
        String username = user.getAttribute("login");

        // Check if user already exists
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM users WHERE username = ?",
                Integer.class,
                username
        );

        // If first time login, insert user
        if (count != null && count == 0) {

            // Insert into users table
            jdbcTemplate.update(
                    "INSERT INTO users(username,password,is_active) " +
                            "VALUES (?,?,?,?)",
                    username,
                    "OAUTH_USER", // dummy password
                    "Y"
            );

            // Assign GIT user role
            jdbcTemplate.update(
                    "INSERT INTO user_roles(user_id,role_name) " +
                            "SELECT user_id,'ROLE_GIT_USER' FROM users WHERE username=?",
                    username
            );
        }

        // Generate JWT for GitHub user
        String token =
                jwtUtil.generateToken(
                        username,
                        List.of("ROLE_GIT_USER")
                );

        // Send token as JSON response
        response.setContentType("application/json");
        response.getWriter()
                .write("{\"token\":\"" + token + "\"}");
    }
}
