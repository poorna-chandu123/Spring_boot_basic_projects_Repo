package com.second_mini_project.Global_Exception;

public class InvalidTempPasswordException extends Unlock_ApiException {


    public InvalidTempPasswordException() {
        super("Temporary password is incorrect");
    }
}
