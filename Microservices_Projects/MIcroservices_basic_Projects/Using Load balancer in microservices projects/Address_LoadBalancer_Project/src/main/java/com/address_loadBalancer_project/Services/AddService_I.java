package com.address_loadBalancer_project.Services;




import com.address_loadBalancer_project.Request.Addrequest;
import com.address_loadBalancer_project.Responces.Addresponces;

import java.util.Optional;
public interface AddService_I {
    // Method to register an address
    public Addresponces addAddress(Addrequest addrequest);

    // Method to get address details by address ID
    public Optional<Addresponces> getAddressById(long addid);
}

