package com.second_mini_project.Controller;


import com.second_mini_project.DTO.*;
import com.second_mini_project.Entity.UserDtlsEntity;
import com.second_mini_project.Services.UserService_inter;
import com.second_mini_project.Services.unlockAccount_Serivice_with_Exception;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService_inter userService;

    @Autowired
    private unlockAccount_Serivice_with_Exception unlockService;

    // signup implementation will go here
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpForm form) throws MessagingException {
        boolean data = userService.signUpUser(form);
        if (!data) {
            return ResponseEntity.badRequest().body("Email already exists kindly use different email");
        } else {
            return ResponseEntity.ok("Account created Kindly check your email to unlock account");
        }


    }

    @PostMapping("/Unlock")
    public ResponseEntity<?> unlockAccount(@RequestBody UnlockForm unlockForm) {
        try {
            userService.unlockAccount(unlockForm);
            return ResponseEntity.ok("Account unlocked successfully");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/Unlock_with_Global_Exception")
    public ResponseEntity<?> unlockAccount(@Valid @RequestBody UnlockForm_with_Global_Exception form) {
        unlockService.unlockAccount(form);
        return ResponseEntity.ok(Map.of("message", "Account unlocked successfully"));
    }

    //login implementation will go here
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm, HttpSession session) {

        Login_ResponcesForm Data = userService.loginCheck(loginForm, session);

        if ("FAILED".equals(Data.getSataus())) {
            return ResponseEntity.badRequest().body(Data);
        } else {

            return ResponseEntity.ok(Data);
        }


    }

    //   // forgot PSW implementation will go here
    @PostMapping("/forgotpsw")
 /*  public ResponseEntity<?> forgotPsw(@RequestBody Map<String, String> form) throws MessagingException {

        String email = form.get("userEmail");
        boolean data = userService.forgotPsw(email);

      // Above code is replaced with below code to directly accept email as JSON string :
      // Normal ga DTO or Entity ni use chese @RequestBody ni use cheyagalamu means JSON Body ni thisukogalamu
      // Kani simple string ni kuda @RequestBody lo use cheyagalamu anduke MAP ni use chesi JSON ni thisukunele convert chesamu

  */
 // 2nd approach to directly accept email as Query Param simple for one or two fields
    public ResponseEntity<?> forgotPsw(@RequestParam String form) throws MessagingException {
        boolean data = userService.forgotPsw(form);
        if (!data) {
            return ResponseEntity.badRequest().body("Invalid Email Address");
        } else {
            return ResponseEntity.ok("Kindly check your email for password");
        }

    }


// log out implementation will go here
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        userService.logout(session);
        return ResponseEntity.ok("Logged out successfully");
    }


}