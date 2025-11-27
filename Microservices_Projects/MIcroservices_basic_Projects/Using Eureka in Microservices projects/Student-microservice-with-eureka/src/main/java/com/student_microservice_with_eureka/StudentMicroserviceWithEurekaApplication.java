package com.student_microservice_with_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudentMicroserviceWithEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMicroserviceWithEurekaApplication.class, args);
	}

}
