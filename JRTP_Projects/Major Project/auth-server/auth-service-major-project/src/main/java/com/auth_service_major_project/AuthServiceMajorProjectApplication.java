package com.auth_service_major_project;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthServiceMajorProjectApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceMajorProjectApplication.class, args);

		System.out.println("AUTH SERVICE for MAJOR PROJECT is UP and RUNNING...");
	}
		// 🔴 TEMPORARY PSW Encoder we in JWT we checking Encode PSW so we need to place
		// in store DB Encoded PSW so name psas chesi psw thisukoni DB lo store chesai URL hit chesamu– REMOVE AFTER USE
		@PostConstruct
		public void printEncodedPassword () {
			System.out.println(
					"ENCODED PASSWORD = " + passwordEncoder.encode("chandu@123")
			);
		}

	}

