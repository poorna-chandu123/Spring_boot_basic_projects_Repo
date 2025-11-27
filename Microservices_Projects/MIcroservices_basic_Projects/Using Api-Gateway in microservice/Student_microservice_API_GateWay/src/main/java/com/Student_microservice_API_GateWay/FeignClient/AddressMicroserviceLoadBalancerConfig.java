//package com.Student_microservice_API_GateWay.FeignClient;
//
//import feign.Feign;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//@LoadBalancerClient(value ="address-microservice")
//public class AddressMicroserviceLoadBalancerConfig {
//
//    @LoadBalanced
//    @Bean
//    Feign.Builder feignBuilder(){
//
//        return Feign.builder();
//    }
//
//}


// Note: Spring Cloud API Gateway anede Spring Load Balancer ni kuda inbuilt ga handle chestundi.
// So, No Need any Special Configuration for Load Balancer.