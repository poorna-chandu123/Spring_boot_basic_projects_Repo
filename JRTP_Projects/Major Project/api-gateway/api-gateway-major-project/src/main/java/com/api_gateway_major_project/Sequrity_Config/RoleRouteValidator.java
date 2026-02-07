package com.api_gateway_major_project.Sequrity_Config;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ===============================
 * ROLE → API ACCESS RULES
 * ===============================
 *
 * PURPOSE:
 * - Central place for authorization rules
 * - Easy to modify when new services are added
 *
 * 🔴 DO NOT put JWT logic here
 * 🔴 DO NOT parse tokens here
 */
@Component
public class RoleRouteValidator {

    /**
     * ROLE → ALLOWED PATHS
     *
     * KEY   = ROLE
     * VALUE = list of allowed API path prefixes
     */
    private static final Map<String, List<String>> ROLE_ACCESS_MAP = Map.of(
            "ROLE_ADMIN", List.of(
                    "/admin-service/",
                    "/user-service/",
                    "/order-service/"
            ),
            "ROLE_USER", List.of(
                    "/user-service/",
                    "/order-service/"
            )
            /* -- we can pass multiple roles too
            ,
            "ROLE_GUEST", List.of(
                    "/user-service/getPublicInfo"
            )

             */
    );

    /**
     * CHECK IF ROLE IS ALLOWED FOR PATH
     */
    public boolean isAuthorized(List<String> roles, String requestPath) {
        for (String role : roles) {
            List<String> allowedPaths = ROLE_ACCESS_MAP.get(role);
            if (allowedPaths != null) {
                for (String path : allowedPaths) {
                    if (requestPath.startsWith(path)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

