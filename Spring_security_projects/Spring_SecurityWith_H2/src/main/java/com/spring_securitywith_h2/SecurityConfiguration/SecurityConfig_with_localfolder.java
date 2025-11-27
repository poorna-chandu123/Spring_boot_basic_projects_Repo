 package com.spring_securitywith_h2.SecurityConfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity  // Role-based security
public class SecurityConfig_with_localfolder {

    @Autowired
    private DataSource dataSource;

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // below code is to allow the h2-console and required URL's with authentication
        // nothing but e code ye URL's avithe authentication lekunda access cheyali anukuntunnamo avi pass cheyali
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated());

        http.sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.httpBasic(withDefaults());
        http.headers(headers -> 
                headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public JdbcUserDetailsManager userDetailsService() {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    /* comparison with SecurityConfig_without_localfolder class code
     Inserts users once at application startup
     User creation separated from userDetailsService() bean
      Better separation of concerns & avoids duplicate execution.
     */
    public CommandLineRunner insertDefaultUsers(DataSource dataSource) {
        return args -> {
            JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

            // Ensure table exists by verifying database metadata
            try (Connection conn = dataSource.getConnection()) {
                DatabaseMetaData metaData = conn.getMetaData();
                ResultSet tables = metaData.getTables(null, null, "USERS", null);

                if (!tables.next()) {
                    System.out.println("USERS table does not exist — schema.sql may not have executed.");
                    return;
                }
            }  

            if (!jdbcUserDetailsManager.userExists("user")) {
                UserDetails user1 = User.withUsername("user")
                     //   .password("{noop}password")  // Nopasswordencoder
                		.password(passwordEncoder().encode("password"))
                        .roles("USER")
                        .build();

                UserDetails user2 = User.withUsername("admin")
                       // .password("{noop}passwordadmin")
                		.password(passwordEncoder().encode("passwordadmin"))
                        .roles("ADMIN")
                        .build();

                jdbcUserDetailsManager.createUser(user1);
                jdbcUserDetailsManager.createUser(user2);

                System.out.println("Users inserted successfully!");
            }
        };
    }

    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    
    
    }
    


/*
Great question — let's break this down **very clearly and deeply** so you understand how Spring behaves here.

---

## ✅ **1. "Runs every time `userDetailsService()` is called" — What does it REALLY mean?**

### **Old code logic**

```java
@Bean
public UserDetailsService userDetailsService() {
    JdbcUserDetailsManager savinguser = new JdbcUserDetailsManager(dataSource);

    if(!savinguser.userExists("user")) {
        savinguser.createUser(user1);
        savinguser.createUser(user2);
    }

    return savinguser;
}
```

### ❓ When does Spring call `@Bean` methods?

* Spring **calls `userDetailsService()`** when it creates the bean during application startup
* If **any other part** of Spring Security needs this bean again, it can internally invoke it (because it's a bean provider)

### ✅ What this means **in practice**

* At application startup, Spring creates this bean
* **Every time Spring Security internally accesses the bean**, this method can run
* So your user creation logic is tied to bean creation logic

### ⚠️ Potential problem

If Spring ever re-initializes the bean internallly (like during context refresh, security updates, etc.), the method runs again.

✅ It **does NOT** run when each user logs in
❌ It **does NOT** run for every HTTP request
❌ It **does NOT** run for every user insert

But it's **unsafe** because:

* Bean methods should **not** contain DB insert logic
* They should only create / return beans

---

## ✅ **2. "Inserts users once at application startup" explained**

### New code logic

```java
@Bean
public CommandLineRunner insertDefaultUsers(DataSource dataSource) {
    return args -> {
        if(!jdbcUserDetailsManager.userExists("user")) {
            createUser(...)
        }
    };
}
```

### What is `CommandLineRunner`?

* A Spring Boot component that runs **after the application context fully loads**
* Runs **only once** when the app starts

### ✅ What this means in practice

When you start your Spring Boot application:

1. Database connection initialized
2. Spring Security beans created
3. **CommandLineRunner executes**
4. It inserts users **ONE TIME**
5. Next startup → checks if users exist → skips inserts

So yes:

> **When app starts, users insert once — not again until next restart**

---

## 🥇 Why second approach is better

| Old Approach                            | New Approach                          |
| --------------------------------------- | ------------------------------------- |
| User insert mixed with bean creation ⚠️ | User insert separated ✅               |
| Could execute more than once            | Executes exactly once per app startup |
| Bean has business logic ❌               | Bean only returns service ✅           |
| Not clean architecture                  | Clean separation of concerns          |

---

## 🌟 Simple Real-world Analogy

| Concept                      | Analogy                                                   |
| ---------------------------- | --------------------------------------------------------- |
| `@Bean userDetailsService()` | Chef prepares kitchen area (beans only, no cooking meals) |
| CommandLineRunner            | Chef cooks welcome dishes **once** when restaurant opens  |

You wouldn't cook meals **inside the kitchen setup function**, right?
Same idea here ✅

---

## Final Answer Summary

| Statement                                              | Meaning                                                                                |
| ------------------------------------------------------ | -------------------------------------------------------------------------------------- |
| **"Runs every time `userDetailsService()` is called"** | Called whenever Spring initializes / accesses the bean — not ideal for inserting users |
| **"Inserts users once at application startup"**        | Only executes ONCE when app boots → perfect for one-time default user setup            |

---

If you'd like, I can also show you:

📌 Flow diagram of Spring startup order
📌 Best practice structure for security config
📌 JWT version for production use

Would you like those?

 */