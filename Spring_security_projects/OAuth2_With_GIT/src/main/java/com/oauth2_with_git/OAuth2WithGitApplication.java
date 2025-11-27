package com.oauth2_with_git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OAuth2WithGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2WithGitApplication.class, args);
		System.out.println("Application is running...");
	}

}
