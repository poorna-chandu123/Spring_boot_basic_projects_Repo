package com.jwt_spring_demo.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import org.slf4j.Logger;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${spring.app.jwtsecret}")
    private String jwtsecret;

    @Value("${spring.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    //getJWTFromHeader
    public String getJWTFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        logger.debug("Bearer Token: {}", bearerToken);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    //genarate token form username
    public String generateTokenfromUsername(UserDetails userDetails) {
       String username = userDetails.getUsername();

       /* String  jwt = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key())
                .compact();
        return jwt;*/
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key())
                .compact();
    }

   //get username from token
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                        .build().parseSignedClaims(token)
                .getBody().getSubject();
    }

    //key() method
 /*   private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtsecret));
    }*/

    private Key key() {
        byte[] decodedKey = Decoders.BASE64.decode(jwtsecret);
        return Keys.hmacShaKeyFor(decodedKey);
    }


    // validate token
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
