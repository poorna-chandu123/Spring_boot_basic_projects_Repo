package com.auth_service_major_project.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
@Component
// Utility class responsible ONLY for JWT generation
public class JwtUtil {

    // Secret key used to sign JWT
    private final Key key;

    // Token expiration time
    private final long expiration;

    public JwtUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration-ms}") long expiration) {

        // Convert secret string into cryptographic key
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiration = expiration;
    }

    // Generate JWT token
    public String generateToken(String username, List<String> roles) {

        return Jwts.builder()
                // Username is token subject
                .setSubject(username)

                // Add roles as custom claim
                .claim("roles", roles)

                // Token issue time
                .setIssuedAt(new Date())

                // Token expiry time
                .setExpiration(
                        new Date(System.currentTimeMillis() + expiration)
                )

                // Sign token using HS256 algorithm
                .signWith(key, SignatureAlgorithm.HS256)

                // Build final token string
                .compact();
    }

    // Expose expiration value to response
    public long getExpiration() {
        return expiration;
    }
}

