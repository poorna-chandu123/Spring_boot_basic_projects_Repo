package com.api_gateway_major_project.Sequrity_Config;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.List;

/**
 * =======================
 * JWT UTILITY CLASS
 * =======================
 *
 * PURPOSE:
 * - Parse JWT token
 * - Validate signature
 * - Check expiry
 * - Extract username & roles
 *
 * 🔴 DO NOT put business logic here
 * 🔴 DO NOT access DB here
 */
@Component
public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);


    private final Key key;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    /**
     * VALIDATES TOKEN
     * - signature
     * - expiry as well
     */
    public Claims validateToken(String token) {
        log.info("in side Validating JWT: {}", token);
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    /**
     * EXTRACT ROLES
     *
     * Auth Service MUST send roles as:
     * "roles": ["ROLE_USER", "ROLE_ADMIN"]
     */
    @SuppressWarnings("unchecked")
    public List<String> extractRoles(Claims claims) {
        return (List<String>) claims.get("roles");
    }
}
