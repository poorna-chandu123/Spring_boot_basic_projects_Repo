package com.auth_service_major_project.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Standard error response structure
public class ErrorResponse {

    // Error message to be sent to client
    private String message;


    // getter
}
