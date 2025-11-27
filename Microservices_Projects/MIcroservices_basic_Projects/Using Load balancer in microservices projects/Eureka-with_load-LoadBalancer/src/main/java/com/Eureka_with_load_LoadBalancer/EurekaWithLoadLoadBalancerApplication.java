package com.Eureka_with_load_LoadBalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaWithLoadLoadBalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaWithLoadLoadBalancerApplication.class, args);
	}

}
