package com.KAFKA_SpringFunction.Cloud_Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class Spring_cloud_Function {

    // Spring Cloud Function edi oka functional interface edi use chesi oka simple Rest
    // API create cheyachhu with out using traditional Rest API code but edi just konni senarios ki matharame use avuthundi
    @Bean
    public Function<String , String> uppercaseFunction() {
        return String::toUpperCase;
    }
}
