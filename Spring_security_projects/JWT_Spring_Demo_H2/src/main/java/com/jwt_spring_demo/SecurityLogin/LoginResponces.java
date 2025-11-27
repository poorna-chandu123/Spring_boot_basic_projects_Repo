package com.jwt_spring_demo.SecurityLogin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponces {

    private String jwtToken;
    private String Username;

    private List<String> roles;

}
