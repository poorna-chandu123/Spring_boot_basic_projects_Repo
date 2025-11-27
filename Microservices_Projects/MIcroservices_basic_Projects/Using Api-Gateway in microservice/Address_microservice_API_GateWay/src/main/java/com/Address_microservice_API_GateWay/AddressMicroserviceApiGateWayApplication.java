package com.Address_microservice_API_GateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressMicroserviceApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressMicroserviceApiGateWayApplication.class, args);
	}

}
