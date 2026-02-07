package com.auth_service_major_project.security;

import com.auth_service_major_project.repository.UserJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
// This class connects Spring Security with your database
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);


    private final UserJdbcRepository repository;

    public CustomUserDetailsService(UserJdbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("Loading user from DB: {}", username);


        // Fetch user from database
        Map<String, Object> user = repository.findUserByUsername(username);

        // Extract user_id from DB result
        Long userId = ((Number) user.get("user_id")).longValue();

        // Check if user is enabled (Y/N)
        boolean enabled =
                "Y".equalsIgnoreCase((String) user.get("is_active"));

        // Fetch user roles
        List<String> roles =
                repository.findRolesByUserId(userId);

        // Convert DB data into Spring Security User object
        return User.builder()
                .username((String) user.get("username"))
                .password((String) user.get("password"))

                // If enabled=false → Spring throws DisabledException
                .disabled(!enabled)

                // Convert roles list to array
                .roles(roles.toArray(new String[0]))
                .build();
    }
}
