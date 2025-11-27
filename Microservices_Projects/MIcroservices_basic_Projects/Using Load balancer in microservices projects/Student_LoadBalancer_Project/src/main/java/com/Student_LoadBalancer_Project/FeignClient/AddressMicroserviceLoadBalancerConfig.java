package com.Student_LoadBalancer_Project.FeignClient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value ="address-microservice")
public class AddressMicroserviceLoadBalancerConfig {

    @LoadBalanced
    @Bean
    Feign.Builder feignBuilder(){

        return Feign.builder();
    }

}