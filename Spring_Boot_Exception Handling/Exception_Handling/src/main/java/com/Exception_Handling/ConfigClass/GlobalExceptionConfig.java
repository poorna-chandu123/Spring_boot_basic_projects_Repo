package com.Exception_Handling.ConfigClass;

import com.Exception_Handling.Controller.ControllerBasedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionConfig {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionConfig.class);

    // Global exception handling logic can be added here for ArithmeticException and other exceptions

    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<ExceptioDAO_Class> handleArithmeticException(ArithmeticException ex) {
        log.error("Global Arithmetic Exception: " + ex.getMessage());
        ExceptioDAO_Class errorResponse = new ExceptioDAO_Class();
        errorResponse.setMsg("Global Based Arithmetic Exception code");
        errorResponse.setErrorCode("ARITH-001");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    // Exception handling for CustomExceptionConfig
    @ExceptionHandler(value = CustomExceptionConfig.class)
    public ResponseEntity<ExceptioDAO_Class> handleCustomException(CustomExceptionConfig ex) {
        log.error("Custom Custom Exception: " + ex.getMessage());
        ExceptioDAO_Class errorResponse = new ExceptioDAO_Class();
        errorResponse.setMsg(ex.getMessage());
        errorResponse.setErrorCode("CUST-001");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
