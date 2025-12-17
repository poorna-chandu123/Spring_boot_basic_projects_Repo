package com.second_mini_project.Services;

import com.second_mini_project.DTO.LoginForm;
import com.second_mini_project.DTO.Login_ResponcesForm;
import com.second_mini_project.DTO.SignUpForm;
import com.second_mini_project.DTO.UnlockForm;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

public interface UserService_inter {

    // sign up method
    public boolean signUpUser(SignUpForm form) throws MessagingException;

    public void unlockAccount(UnlockForm unlockForm);

    // login method
    public Login_ResponcesForm loginCheck(LoginForm loginForm, HttpSession session);

    // Forgot PSW method
    public boolean forgotPsw(String userEmail) throws MessagingException;

    // logout method
    public void logout(HttpSession session);
}