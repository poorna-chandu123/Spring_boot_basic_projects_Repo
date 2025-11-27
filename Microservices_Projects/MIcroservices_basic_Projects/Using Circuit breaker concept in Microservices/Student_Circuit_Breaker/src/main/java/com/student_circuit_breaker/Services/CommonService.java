package com.student_circuit_breaker.Services;


import com.student_circuit_breaker.FeignClient.AddressFeignClient;
import com.student_circuit_breaker.Responces.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommonService {

    Logger logger = LoggerFactory.getLogger(CommonService.class);


    @Autowired
    AddressFeignClient addressFeignClient;


    long count =1;


    @CircuitBreaker(name = "addressMicroserviceCommonService",fallbackMethod = "fallBackGetAddressById")
    public AddressResponse getAddressByIdCommonService (long addressId) {

        logger.info("Count =  " + count);
        count++;

        AddressResponse addressResponse =
                addressFeignClient.getById(addressId);

        return addressResponse;
    }



    public AddressResponse fallBackGetAddressById (long addressId, Throwable th) {     //Throwable is optional

        logger.error("Error = " + th);
        return new AddressResponse();
    }

}
