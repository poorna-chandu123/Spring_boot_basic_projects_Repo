package com.auth_service_major_project.config;

import com.auth_service_major_project.oauth.OAuth2SuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// Tells Spring this class contains security-related beans
@EnableWebSecurity
// Enables Spring Security filter chain
@EnableMethodSecurity
// Enables @PreAuthorize, @Secured if needed later
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // Disable CSRF because we are stateless (JWT based)
                .csrf(AbstractHttpConfigurer::disable)

         /*       // ❗ IMPORTANT: disable browser-based login
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable) */

                // Tell Spring: DO NOT create HTTP session
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Authorization rules
                .authorizeHttpRequests(auth -> auth
                        // Public endpoints (no authentication required)
                        .requestMatchers(
                                "/auth/login",
                                "/auth/oauth2/**",
                                "/actuator/**"
                        ).permitAll()

                        // Any other endpoint must be authenticated
                        .anyRequest().authenticated()
                )

                // Enable OAuth2 login (GitHub) // OAuth2 ONLY for browser flow
                .oauth2Login(oauth ->
                        // After successful OAuth login, call this handler
                        oauth.successHandler(oAuth2SuccessHandler())
                );

        // Build and return security filter chain
        return http.build();
    }

    @Bean
    // Custom success handler for OAuth login
    public OAuth2SuccessHandler oAuth2SuccessHandler() {
        return new OAuth2SuccessHandler();
    }

    @Bean
    // Password encoder used by Spring Security to compare passwords
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // AuthenticationManager is the core engine of Spring Security
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager();
    }
}
