package com.oauth2_with_jwt.Controller;



import com.oauth2_with_jwt.Security.JwtUtils_mysql;
import com.oauth2_with_jwt.SecurityLogin.LoginRequest_mysql;
import com.oauth2_with_jwt.SecurityLogin.LoginResponces_mysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/JWT")
public class JWTController_mysql {

    @Autowired
    private JwtUtils_mysql jwtUtilsMysql;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest_mysql loginRequestMysql) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestMysql.getUsername(), loginRequestMysql.getPassword()));
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Invalid username or password");
        }
        /*}catch (AuthenticationException exception){
            Map<String ,Object> map = new HashMap<>();
            map.put("message","Bad credentials");
            map.put("status",false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }*/

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = jwtUtilsMysql.generateTokenFromUsername(String.valueOf(userDetails));
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        LoginResponces_mysql loginResponcesMysql = new LoginResponces_mysql(jwt, userDetails.getUsername(), roles);
        return ResponseEntity.ok(loginResponcesMysql);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody LoginRequest_mysql loginRequestMysql) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Create user with the provided username and password
        String userRole = loginRequestMysql.getRole();

        jdbcUserDetailsManager.createUser(org.springframework.security.core.userdetails.User.withUsername(loginRequestMysql.getUsername())
                .password(passwordEncoder.encode(loginRequestMysql.getPassword()))
                .roles(userRole)  // Use user-provided role instead of hardcoding
                .build());

        return ResponseEntity.ok("User registered successfully!");
    }


}
