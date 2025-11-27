package com.address_microservice_with_eureka.Services;



import com.address_microservice_with_eureka.Request.Addrequest;
import com.address_microservice_with_eureka.Responces.Addresponces;

import java.util.Optional;
public interface AddService_I {
    // Method to register an address
    public Addresponces addAddress(Addrequest addrequest);

    // Method to get address details by address ID
    public Optional<Addresponces> getAddressById(long addid);
}

