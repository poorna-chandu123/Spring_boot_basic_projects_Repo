package com.second_mini_project.Global_Exception;

public class PasswordMismatchException extends Unlock_ApiException{
    public PasswordMismatchException() {
        super("New password and confirm password do not match");
    }
}
