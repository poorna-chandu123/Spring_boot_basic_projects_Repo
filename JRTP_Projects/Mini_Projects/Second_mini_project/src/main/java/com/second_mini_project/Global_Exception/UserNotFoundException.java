package com.second_mini_project.Global_Exception;

public class UserNotFoundException  extends Unlock_ApiException {
    public UserNotFoundException() {
        super("Account not found for the given email");
    }
}
