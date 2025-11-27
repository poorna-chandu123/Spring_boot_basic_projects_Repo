package com.jwt_with_mysql.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig_mysql {

    @Autowired
    private DataSource dataSource; // Ensure dataSource is injected
    @Autowired
    private AuthEntryPointJwt_mysql unauthorizedHandler;

    @Bean
    public AuthTokenFilter_mysql authenticationJwtTokenFilter() {
        return new AuthTokenFilter_mysql();
    }

 @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/JWT/signin").permitAll()
                        .requestMatchers("/JWT/signup").permitAll()
                        .requestMatchers("/api/demo").authenticated()
                        .anyRequest().authenticated());

        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //exceptionhandling
        http.exceptionHandling(exception -> exception
                .authenticationEntryPoint(unauthorizedHandler));

       // http.httpBasic(withDefaults());
        http.headers(headers ->
                headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        http.csrf(AbstractHttpConfigurer::disable);
        // below is the custom  filter which we created and will are telling exact which point it should exiguity
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public UserDetailsService  userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    /*@Bean
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
    }*/

/*

@Bean
public CommandLineRunner initData (UserDetailsService userDetailsService) {
return args -> {
    JdbcUserDetailsManager manager = (JdbcUserDetailsManager) userDetailsService;

        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    jdbcUserDetailsManager.createUser(user);
    jdbcUserDetailsManager.createUser(admin);

};
}
*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
