package com.spring_securitywith_h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityWithH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithH2Application.class, args);
		
		System.out.println("Application is running");
	}

}
