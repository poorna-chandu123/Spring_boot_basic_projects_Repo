package com.oauth2_spring_demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/Demo")
public class HelloController {

    @GetMapping("/hello")
    public String greet(){
        return "Welcome to Telusko";
    }
}
