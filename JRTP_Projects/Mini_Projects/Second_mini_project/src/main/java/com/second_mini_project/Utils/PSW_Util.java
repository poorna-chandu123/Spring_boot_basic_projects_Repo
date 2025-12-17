package com.second_mini_project.Utils;

import org.springframework.stereotype.Component;
import org.apache.commons.lang3.RandomStringUtils;


@Component
public class PSW_Util {

    public static String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return RandomStringUtils.random(5, characters);
    }
}
