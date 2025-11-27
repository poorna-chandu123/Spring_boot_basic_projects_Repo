package com.api_gateway_circuit_breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayCircuitBreakerApplication.class, args);
	}

}
