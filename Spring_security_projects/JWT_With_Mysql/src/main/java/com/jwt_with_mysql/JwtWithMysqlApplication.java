package com.jwt_with_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtWithMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtWithMysqlApplication.class, args);

		System.out.println("Application is running");
	}

}
