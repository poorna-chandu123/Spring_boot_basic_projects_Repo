package com.auth_service_major_project.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
// Repository layer: ONLY database access
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    // SQL loaded from config server (externalized)
    @Value("${sql.user-by-username}")
    private String userByUsernameSql;

    @Value("${sql.roles-by-userid}")
    private String rolesByUserIdSql;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Fetch user record using username
    public Map<String, Object> findUserByUsername(String username) {

        // queryForMap returns a single row as key-value pairs
        return jdbcTemplate.queryForMap(userByUsernameSql, username);
    }

    // Fetch roles for given user ID
    public List<String> findRolesByUserId(Long userId) {

        // queryForList returns list of role names
        return jdbcTemplate.queryForList(
                rolesByUserIdSql,
                String.class,
                userId
        );
    }
}
