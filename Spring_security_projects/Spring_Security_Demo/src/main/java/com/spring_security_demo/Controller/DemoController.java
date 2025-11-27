package com.spring_security_demo.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasRole;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "Demo..... Greetings from Spring Security!";
    }

    // admin getmapping
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Admin..... Greetings from Spring Security!";
    }
    // user getmapping
    @PreAuthorize("hasRole('USER')") // role base authentication kosam e anotation ni add cheyali
    @GetMapping("/user")
    public String user() {
        return "User..... Greetings from Spring Security!";
    }
}

