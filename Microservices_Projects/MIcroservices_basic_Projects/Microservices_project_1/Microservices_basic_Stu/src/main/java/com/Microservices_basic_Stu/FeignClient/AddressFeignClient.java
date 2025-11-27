package com.Microservices_basic_Stu.FeignClient;


import com.Microservices_basic_Stu.Responces.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Here "${address.service.url}" is loading the URL from application.properties file
@FeignClient(url = "${address.service.url}", value = "address-feign-client",
        path = "/address")
public interface AddressFeignClient {

    @GetMapping("/get/{id}") // Note:- Address project lo ye rest end point echhamo same ade name tho eikkada evvali
    public AddressResponse getById(@PathVariable long id);

}
