package com.second_mini_project.DTO;


import lombok.Data;

@Data
public class UnlockForm {

    private String userEmail;
    private String tempPsw;
    private String newPsw;
    private String confirmPsw;

}
