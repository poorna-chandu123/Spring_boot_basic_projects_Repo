//package com.spring_securitywith_h2.Entity;
//
//import jakarta.persistence.*;
//
//import java.util.Set;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @Column(name = "username", length = 50, nullable = false, unique = true)
//    private String username;
//
//    @Column(name = "password", length = 500, nullable = false)
//    private String password;
//
//    @Column(name = "enabled", nullable = false)
//    private boolean enabled;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Authority> authorities;
//
//    // Constructors
//    public User() {}
//
//    public User(String username, String password, boolean enabled) {
//        this.username = username;
//        this.password = password;
//        this.enabled = enabled;
//    }
//
//    // Getters and Setters
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public Set<Authority> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(Set<Authority> authorities) {
//        this.authorities = authorities;
//    }
//}

// Entity class commended out due to table creation via schema.sql file