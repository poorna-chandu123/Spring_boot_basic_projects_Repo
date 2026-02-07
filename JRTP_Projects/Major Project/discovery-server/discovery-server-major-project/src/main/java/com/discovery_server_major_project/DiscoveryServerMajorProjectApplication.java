package com.discovery_server_major_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * DISCOVERY SERVER MAIN CLASS
 *
 * @EnableEurekaServer
 * -------------------
 * Turns this Spring Boot app into Eureka Server
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerMajorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerMajorProjectApplication.class, args);
		System.out.println("DISCOVERY SERVER STARTED...");
	}

}
