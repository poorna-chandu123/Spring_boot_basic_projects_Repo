package com.second_mini_project.Services;

import com.second_mini_project.DTO.LoginForm;
import com.second_mini_project.DTO.Login_ResponcesForm;
import com.second_mini_project.DTO.SignUpForm;
import com.second_mini_project.DTO.UnlockForm;
import com.second_mini_project.Entity.UserDtlsEntity;
import com.second_mini_project.Repo.UserDtlsRepo;
import com.second_mini_project.Utils.Email_Util;
import com.second_mini_project.Utils.PSW_Util;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService_IMP implements UserService_inter {

    @Autowired
    private UserDtlsRepo userDtlsRepo;

    @Autowired
    private Email_Util emailUtil;



    // Sign up method implementation
    @Override
    public boolean signUpUser(SignUpForm form) throws MessagingException {

        UserDtlsEntity byEmail = userDtlsRepo.findByUserEmail(form.getUserEmail());

        if (byEmail != null) {
            // TODO user already exist
            return false;
        }

        // TODO copy data from binding object to entity object
        UserDtlsEntity user = new UserDtlsEntity();
        BeanUtils.copyProperties(form, user);

        // TODO genarate password
        String temPSW = PSW_Util.generatePassword();
        user.setUserPassword(temPSW);

        // TODO set account lock by default
        user.setUserAccStatus("LOCKED");

        // TODO insert into db
        userDtlsRepo.save(user);

        // TODO send email to user with temp PSW

        String toEmail = form.getUserEmail();
        String subject = "Welcome to Our Service - Activate Your Account";
        String body = "Dear User,\n\n" +
                "Thank you for signing up! Your account has been created successfully.\n" +
                "Please use the Temporary Password & link for unlock :\n\n" +
                "TEMP PSW: " + temPSW + "\n\n" +
                "LINK: http://localhost:8080/user/unlock/?email=" + toEmail + "\n\n"
                ;
        emailUtil.sendEmail(toEmail, subject, body);


        return true;

    }

    // Unlock account method implementation without extra exception classes
    @Override
    public void unlockAccount(UnlockForm unlockForm) {

        UserDtlsEntity byEmail = userDtlsRepo.findByUserEmail(unlockForm.getUserEmail());

        if (byEmail == null) {
            throw new RuntimeException("user not found");
        }else if(!byEmail.getUserPassword().equals(unlockForm.getTempPsw())){
            // TODO throw exception
            throw new RuntimeException("Temporary password is incorrect");
        }else if (!unlockForm.getNewPsw().equals(unlockForm.getConfirmPsw())){
            // TODO throw exception
            throw new RuntimeException("New password and confirm password does not match");
        }else {
            // TODO update the user details
            byEmail.setUserPassword(unlockForm.getNewPsw());
            byEmail.setUserAccStatus("UNLOCKED");
            userDtlsRepo.save(byEmail);
        }


    }

    // Login method implementation
    @Override
    public Login_ResponcesForm loginCheck(LoginForm loginForm, HttpSession session) {
        // check user exist with given email and psw
        UserDtlsEntity byEmailAndUserPsw = userDtlsRepo.findByUserEmailAndUserPassword(loginForm.getUserEmail(), loginForm.getUserPsw());

        Login_ResponcesForm loginResponcesForm = new Login_ResponcesForm();
        // check user not exist
        if (byEmailAndUserPsw == null){
            loginResponcesForm.setSataus("FAILED");
            loginResponcesForm.setMassage("Invalid Credentials");
            return loginResponcesForm;
        }else if(byEmailAndUserPsw.getUserAccStatus().equals("LOCKED")){
            // check account is locked
            loginResponcesForm.setUserName(byEmailAndUserPsw.getUserName());
            loginResponcesForm.setSataus("FAILED");
            loginResponcesForm.setMassage("Your Account is Locked. Please unlock your account.");
                return loginResponcesForm;
            } else {
                // TODO success login --> modified session code for user performance functionality
            // TODO set session attribute
            // 🔴 IMPORTANT: store logged-in user in session
                session.setAttribute("userID", byEmailAndUserPsw.getUserId());
                session.setAttribute("userName", byEmailAndUserPsw.getUserName()); // optional

                loginResponcesForm.setUserName(byEmailAndUserPsw.getUserName());
                loginResponcesForm.setSataus("SUCCESS");
                loginResponcesForm.setMassage("Login Successful");
                return loginResponcesForm;
            }
        }

    @Override
    public boolean forgotPsw(String userEmail) throws MessagingException {

        UserDtlsEntity byEmail = userDtlsRepo.findByUserEmail(userEmail);
        if (byEmail != null) {
            // TODO send email to user with psw
            String toEmail = byEmail.getUserEmail();
            String subject = "Your Account Password Recovery";
            String body = "Dear User,\n\n" +
                    "As per your request, here is your account password:\n\n" +
                    "Password: " + byEmail.getUserPassword() + "\n\n" +
                    "Please keep it secure and consider changing it after logging in.\n\n" ;

            emailUtil.sendEmail(toEmail, subject, body);
            return true;
        } else {
            // TODO user not found
            return false;
        }

    }

    // logout method implementation
    @Override
    public void logout(HttpSession session) {
        session.invalidate();

    }
}


