package com.jwt_spring_demo.Controller;

import com.jwt_spring_demo.Security.JwtUtils;
import com.jwt_spring_demo.SecurityLogin.LoginRequest;
import com.jwt_spring_demo.SecurityLogin.LoginResponces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/JWT")
public class JWTController {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
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
        String jwt = jwtUtils.generateTokenfromUsername(userDetails);
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        LoginResponces loginResponces = new LoginResponces(jwt, userDetails.getUsername(), roles);
        return ResponseEntity.ok(loginResponces);

    }

}
