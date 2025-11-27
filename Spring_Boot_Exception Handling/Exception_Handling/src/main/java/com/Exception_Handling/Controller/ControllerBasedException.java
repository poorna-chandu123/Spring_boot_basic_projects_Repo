package com.Exception_Handling.Controller;

import com.Exception_Handling.ConfigClass.ExceptioDAO_Class;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ControllerBasedException {

    private Logger log = LoggerFactory.getLogger(ControllerBasedException.class);
    @GetMapping("/test")
    public String testException() {
        String msg = "Conterller Based Exception Handling";
        try {
            // Simulate an exception
            int result = 10 / 0;
            return "Result: " + result;
        } catch (Exception e) {
                //   e.printStackTrace();
            log.error("Exception caught: "+e.getMessage());
          //  return msg;
            throw new ArithmeticException(e.getMessage()); // Rethrow as ArithmeticException to be handled by @ExceptionHandler
            // ala send chesetappudu retun key ward use cheyyakudadhu because Exception ni @ExceptionHandler ki throw chesthunnam kanuka

        }
      // return msg;
    }

    // Arithmetic Exception Handler for Above controller
    @ExceptionHandler(value = ArithmeticException.class)
     public ResponseEntity<ExceptioDAO_Class> handleArithmeticException(ArithmeticException ex) {
         log.error("Handled Arithmetic Exception: " + ex.getMessage());
            ExceptioDAO_Class errorResponse = new ExceptioDAO_Class();
            errorResponse.setMsg("Controller Based Arithmetic Exception Handled");
            errorResponse.setErrorCode("ARITH-001");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
