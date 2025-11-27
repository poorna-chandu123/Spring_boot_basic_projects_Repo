package com.Student_microservice_API_GateWay.FeignClient;


import com.Student_microservice_API_GateWay.Responces.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "address-microservice-api-gateway",
        path = "/address") // Note:- Address project lo URL ni eistham
public interface AddressFeignClient {

    @GetMapping("/get/{id}") // Note:- Address project lo ye rest end point echhamo same ade name tho eikkada evvali
    public AddressResponse getById(@PathVariable long id);

}
