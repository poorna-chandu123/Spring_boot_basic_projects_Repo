package com.oauth2_with_jwt.SecurityLogin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponces_mysql {

    private String jwtToken;
    private String Username;

    private List<String> roles;

}
