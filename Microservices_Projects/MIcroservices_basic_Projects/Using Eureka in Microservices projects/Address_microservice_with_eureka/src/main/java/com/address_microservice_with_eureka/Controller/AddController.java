package com.address_microservice_with_eureka.Controller;



import com.address_microservice_with_eureka.Request.Addrequest;
import com.address_microservice_with_eureka.Responces.Addresponces;
import com.address_microservice_with_eureka.Services.AddService_I;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address") // this URL we will use in Feign client class
public class AddController {

    @Autowired
    private AddService_I addService_i;

    // POST mapping to add an address
    @PostMapping("/add")
    public Addresponces addAddress(@RequestBody Addrequest addrequest) {
        return addService_i.addAddress(addrequest);
    }

    // GET mapping to get address by ID
    @GetMapping("/get/{addid}")
    public Optional<Addresponces> getAddressById(@PathVariable long addid) {
        return addService_i.getAddressById(addid);
    }
}
