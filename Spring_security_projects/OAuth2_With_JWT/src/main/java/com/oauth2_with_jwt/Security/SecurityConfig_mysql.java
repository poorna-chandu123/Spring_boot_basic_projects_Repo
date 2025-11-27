package com.oauth2_with_jwt.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
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

    @Bean
    public AuthTokenFilter_mysql authenticationJwtTokenFilter() {
        return new AuthTokenFilter_mysql();
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions().sameOrigin())

              //  .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // ✅ Use session only if required (needed for GitHub OAuth)
                  .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))

                // JWT auth entry point
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))

                // Public and secured endpoints
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/JWT/signin", "/JWT/signup", "/public/greet").permitAll()
                        .anyRequest().authenticated()
                )

                // ✅ GitHub OAuth2 Login flow + issue JWT

                .oauth2Login(oauth -> oauth.successHandler((request, response, authentication) -> {
                    OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
                    OAuth2User oauthUser = oauthToken.getPrincipal();
                    String username = oauthUser.getAttribute("login"); // GitHub username
                    String jwt = jwtUtils.generateTokenFromUsername(username);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"token\": \"" + jwt + "\"}");
                    request.getSession().invalidate(); // 🧹 clear session after login --> added this extra line for
                    //OAuth2 login complete aiyaka session lo unnecessary ga data vundakunda clear cheyadam (OAuth2 login ki session kavali but JWT issue ayyaka session unnecessary)
                }));


        // JWT filter for API requests
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
        /*
        when i tested this code in chrome http://localhost:8080/oauth2/authorization/github gives a JWT but with that JWT token if i am trying to access
        in post /demo - rest end point i am getting     "message": "Full authentication is required to access this resource",
        because i am using "JdbcUserDetailsManager" i am combining JWT + Spring Security built-in user management
        so i need to store git login username and details then it will work
        Note : but without storing also it is possible but vere vidam ga cheyali but adi eppudu cheyaledu

         */

    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
