package com.address_circuit_breaker.Services;



import com.address_circuit_breaker.Request.Addrequest;
import com.address_circuit_breaker.Responces.Addresponces;

import java.util.Optional;
public interface AddService_I {
    // Method to register an address
    public Addresponces addAddress(Addrequest addrequest);

    // Method to get address details by address ID
    public Optional<Addresponces> getAddressById(long addid);
}

