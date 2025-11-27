package com.Eureka_server_circuit_breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaServer
public class EurekaServerCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerCircuitBreakerApplication.class, args);
	}

}
