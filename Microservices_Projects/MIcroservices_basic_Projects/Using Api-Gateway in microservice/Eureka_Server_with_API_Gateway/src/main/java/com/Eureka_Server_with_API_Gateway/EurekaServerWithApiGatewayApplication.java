package com.Eureka_Server_with_API_Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaServer
public class EurekaServerWithApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerWithApiGatewayApplication.class, args);
	}

}
