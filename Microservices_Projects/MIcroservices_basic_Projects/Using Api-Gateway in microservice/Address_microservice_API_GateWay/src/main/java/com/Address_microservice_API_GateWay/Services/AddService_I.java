package com.Address_microservice_API_GateWay.Services;


import com.Address_microservice_API_GateWay.Request.Addrequest;
import com.Address_microservice_API_GateWay.Responces.Addresponces;

import java.util.Optional;
public interface AddService_I {
    // Method to register an address
    public Addresponces addAddress(Addrequest addrequest);

    // Method to get address details by address ID
    public Optional<Addresponces> getAddressById(long addid);
}

