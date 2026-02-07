package com.config_server_major_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * MAIN ENTRY POINT FOR CONFIG SERVER
 *
 * @EnableConfigServer
 * -------------------
 * This annotation converts this Spring Boot application
 * into a Config Server.
 *
 * Without this annotation:
 * ❌ Config Server will NOT work
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerMajorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerMajorProjectApplication.class, args);
		System.out.println("CONFIG SERVER for MAJOR PROJECT is UP and RUNNING...");
	}

}
