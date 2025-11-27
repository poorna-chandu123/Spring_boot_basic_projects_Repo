package com.oauth2_with_git.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig_mysql {

    @Autowired
    private AuthEntryPointJwt_mysql unauthorizedHandler;

    @Autowired
    private JwtUtils_mysql jwtUtils;

    @Autowired
    private DataSource dataSource;

    @Bean
    public AuthTokenFilter_mysql authenticationJwtTokenFilter() {
        return new AuthTokenFilter_mysql();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/JWT/signin", "/JWT/signup", "/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth -> oauth.successHandler((request, response, authentication) -> {
                    OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
                    OAuth2User oauthUser = oauthToken.getPrincipal();
                    String username = oauthUser.getAttribute("login");

                    // Save to DB if not exists
                    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                    Integer count = jdbcTemplate.queryForObject(
                            "SELECT COUNT(*) FROM users WHERE username = ?", Integer.class, username);
                    if (count != null && count == 0) {
                        jdbcTemplate.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, true)", username, "N/A");
                        jdbcTemplate.update("INSERT INTO authorities (username, authority) VALUES (?, ?)", username, "GIT_USER");
                    }

                    // Generate JWT
                    String jwt = jwtUtils.generateTokenFromUsername(username);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"token\": \"" + jwt + "\"}");
                }));

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
