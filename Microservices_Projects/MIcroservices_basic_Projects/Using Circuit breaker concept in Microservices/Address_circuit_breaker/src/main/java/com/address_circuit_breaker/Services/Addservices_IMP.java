package com.address_circuit_breaker.Services;



import com.address_circuit_breaker.Entity.Address;
import com.address_circuit_breaker.Repository.Addrepo;
import com.address_circuit_breaker.Request.Addrequest;
import com.address_circuit_breaker.Responces.Addresponces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Addservices_IMP implements AddService_I {

    @Autowired
    private Addrepo addrepo;

    @Override
    public Addresponces addAddress(Addrequest addrequest) {
        // Debug: print incoming request data
        System.out.println("Received AddRequest - City: " + addrequest.getCITY() + ", State: " + addrequest.getState());

        // Convert Addrequest DTO to Address entity
        Address address = new Address();
        address.setCity(addrequest.getCITY());
        address.setState(addrequest.getState());

        // Debug: print Address before saving to database
        System.out.println("Address before saving: " + address);

        // Save the address entity to the database
        Address savedAddress = addrepo.save(address);

        // Debug: print the saved Address entity
        System.out.println("Saved Address: " + savedAddress);

        // Create and return Addresponces object using the constructor
        return new Addresponces(savedAddress.getAddid(), savedAddress.getCity(), savedAddress.getState());
    }



    @Override
    public Optional<Addresponces> getAddressById(long addid) {
        // Retrieve address from the repository by ID
        Optional<Address> address = addrepo.findById(addid);

        // Map Address entity to Addresponces DTO and return it
        return address.map(a -> new Addresponces(a.getAddid(), a.getCity(), a.getState()));
    }
}
