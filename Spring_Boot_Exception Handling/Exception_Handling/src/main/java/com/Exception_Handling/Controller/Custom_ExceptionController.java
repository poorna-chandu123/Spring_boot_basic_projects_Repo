package com.Exception_Handling.Controller;

import com.Exception_Handling.ConfigClass.CustomExceptionConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class Custom_ExceptionController {

    @GetMapping("/test2")
    public String CustomException(@RequestBody String name){
        if (name == null || !name.equals("Ram")){
            throw new CustomExceptionConfig("Name cannot be null or empty");
        }
        return "Welcome " + name;

    }


}
