package com.Eureka_Server_Spring_Boot_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerSpringBootAppApplication.class, args);
	}

}
