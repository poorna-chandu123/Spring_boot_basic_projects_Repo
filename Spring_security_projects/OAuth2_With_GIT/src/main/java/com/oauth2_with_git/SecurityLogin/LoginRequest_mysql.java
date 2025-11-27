package com.oauth2_with_git.SecurityLogin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequest_mysql {
    private String username;
    private String password;
    private String role;

}
