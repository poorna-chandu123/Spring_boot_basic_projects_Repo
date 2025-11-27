package com.Microservices_basic_add.Services;

import com.Microservices_basic_add.Entity.Address;
import com.Microservices_basic_add.Request.Addrequest;
import com.Microservices_basic_add.Responces.Addresponces;

import java.util.Optional;
public interface AddService_I {
    // Method to register an address
    public Addresponces addAddress(Addrequest addrequest);

    // Method to get address details by address ID
    public Optional<Addresponces> getAddressById(long addid);
}

