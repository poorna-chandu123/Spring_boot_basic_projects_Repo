package com.student_microservice_with_eureka.FeignClient;


import com.student_microservice_with_eureka.Responces.AddressResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "address-microservice-with-eureka",
        path = "/address") // Note:- Address project lo URL ni eistham
public interface AddressFeignClient {

    @GetMapping("/get/{id}") // Note:- Address project lo ye rest end point echhamo same ade name tho eikkada evvali
    public AddressResponse getById(@PathVariable long id);

}
