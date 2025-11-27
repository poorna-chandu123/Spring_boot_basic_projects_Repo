package com.address_circuit_breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressCircuitBreakerApplication.class, args);
	}

}
