package com.api_gateway_major_project.Sequrity_Config;


import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import reactor.core.publisher.Mono;


import java.util.List;

/**
 * ============================
 * GLOBAL JWT FILTER
 * ============================
 *
 * PURPOSE:
 * - Runs for EVERY request
 * - Checks Authorization header
 * - Validates JWT
 * - Blocks unauthorized access
 *
 * 🔴 This is the HEART of security
 */
@Component
public class JwtAuthenticationFilter implements GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);


  /*  te below code is up to  Phase 2 and  I added phase 3 code that's why i commented this

  private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getPath().toString();

        // ===============================
        // PUBLIC ENDPOINTS (NO JWT)
        // ===============================
        if (path.startsWith("/auth/") || path.startsWith("/actuator")) {
            return chain.filter(exchange);
        }

        // ===============================
        // CHECK AUTH HEADER
        // ===============================
        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7);

        try {
            Claims claims = jwtUtil.validateToken(token);

            // (Optional) Roles can be added to headers later
            // List<String> roles = jwtUtil.extractRoles(claims);

        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }


   */


    private final JwtUtil jwtUtil;
    private final RoleRouteValidator roleRouteValidator;

    public JwtAuthenticationFilter(JwtUtil jwtUtil,
                                   RoleRouteValidator roleRouteValidator) {
        this.jwtUtil = jwtUtil;
        this.roleRouteValidator = roleRouteValidator;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getPath().toString();

        log.info("inside filter method of JwtAuthenticationFilter, request path: {}", path);

        // ===============================
        // PUBLIC ENDPOINTS
        // ===============================
        if (path.startsWith("/auth/")
                || path.startsWith("/actuator")) {
            return chain.filter(exchange);
        }

        // ===============================
        // AUTH HEADER CHECK
        // ===============================
        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        log.info("Bearer token found in Authorization header");

        String token = authHeader.substring(7);

        try {
            Claims claims = jwtUtil.validateToken(token);
            List<String> roles = jwtUtil.extractRoles(claims);

            // ===============================
            // ROLE AUTHORIZATION CHECK
            // ===============================
            if (!roleRouteValidator.isAuthorized(roles, path)) {
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }

        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
log.info("JWT validated and user authorized for path: {}", path);
        return chain.filter(exchange);
    }
}

