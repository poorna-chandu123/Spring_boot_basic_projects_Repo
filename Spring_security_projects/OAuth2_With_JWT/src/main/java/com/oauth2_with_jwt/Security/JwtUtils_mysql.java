package com.oauth2_with_jwt.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
@Component
public class JwtUtils_mysql {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils_mysql.class);

    @Value("${spring.app.jwtsecret}")
    private String jwtsecret;

    @Value("${spring.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String getJWTFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        logger.debug("Bearer Token: {}", bearerToken);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build().parseSignedClaims(token)
                .getBody().getSubject();
    }

    private Key key() {
        byte[] decodedKey = Decoders.BASE64.decode(jwtsecret);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(authToken);
            return true;
        } catch (Exception e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        }
        return false;
    }
}
