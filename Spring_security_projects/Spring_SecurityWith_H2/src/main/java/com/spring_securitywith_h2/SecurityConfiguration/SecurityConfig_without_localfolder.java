//package com.spring_securitywith_h2.SecurityConfiguration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig_without_localfolder {
//
//    @Autowired
//    private DataSource dataSource; // Ensure dataSource is injected
//
//    @Bean
//    @Order(SecurityProperties.BASIC_AUTH_ORDER)
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) ->
//                requests.requestMatchers("/h2-console/**").permitAll()
//                        .anyRequest().authenticated()
//        );
//
//        http.sessionManagement(session ->
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        );
//
//        http.httpBasic(withDefaults());
//
//        http.headers(headers ->
//                headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
//        );
//
//        http.csrf(AbstractHttpConfigurer::disable);
//
//        return http.build();
//    }
//
//    @Bean
//    /* User Creation Mechanism differences with SecurityConfig_with_localfolder class code
//    Users are inserted inside the UserDetailsService bean
//    Runs every time userDetailsService() is called
//     */
//    public UserDetailsService userDetailsService() {
//        JdbcUserDetailsManager savinguser = new JdbcUserDetailsManager(dataSource);
//
//        // Ensure table exists before inserting data
//        if (!savinguser.userExists("user")) {
//            UserDetails user1 = User.withUsername("user")
//                    .password("{noop}password")
//                    .roles("USER")
//                    .build();
//
//            UserDetails user2 = User.withUsername("admin")
//                    .password("{noop}password")
//                    .roles("ADMIN")
//                    .build();
//
//            savinguser.createUser(user1);
//            savinguser.createUser(user2);
//        }
//
//        return savinguser;
//    }
//}


