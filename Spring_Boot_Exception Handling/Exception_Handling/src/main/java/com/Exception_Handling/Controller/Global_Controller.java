package com.Exception_Handling.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")
public class Global_Controller {


    private Logger log = LoggerFactory.getLogger(ControllerBasedException.class);
    @GetMapping("/test1")
    public String testException() {
        String msg = "Global Based Exception Handling";
        try {
            // Simulate an exception
            int result = 10 / 0;
            return "Result: " + result;
        } catch (Exception e) {
            //   e.printStackTrace();
            log.error("Global Exception caught: "+e.getMessage());
            //  return msg;
            throw new ArithmeticException(e.getMessage()); // Rethrow as ArithmeticException to be handled by @ExceptionHandler
            // ala send chesetappudu retun key ward use cheyyakudadhu because Exception ni @ExceptionHandler ki throw chesthunnam kanuka

        }
        // return msg;
    }
}
