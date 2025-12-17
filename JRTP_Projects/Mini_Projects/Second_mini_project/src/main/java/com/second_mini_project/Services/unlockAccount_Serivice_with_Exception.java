package com.second_mini_project.Services;

import com.second_mini_project.DTO.UnlockForm_with_Global_Exception;
import com.second_mini_project.Entity.UserDtlsEntity;
import com.second_mini_project.Global_Exception.InvalidTempPasswordException;
import com.second_mini_project.Global_Exception.PasswordMismatchException;
import com.second_mini_project.Global_Exception.UserNotFoundException;
import com.second_mini_project.Repo.UserDtlsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class unlockAccount_Serivice_with_Exception {

    @Autowired
    private UserDtlsRepo userDtlsRepo;

    public void unlockAccount(UnlockForm_with_Global_Exception form) {
        UserDtlsEntity user = userDtlsRepo.findByUserEmail(form.getUserEmail());

        if (user == null) {
            throw new UserNotFoundException();
        }

        // Check temporary password
        if (!user.getUserPassword().equals(form.getTempPsw())) {
            throw new InvalidTempPasswordException();
        }

        // Check new & confirm password
        if (!form.getNewPsw().equals(form.getConfirmPsw())) {
            throw new PasswordMismatchException();
        }

        // All good → update
        user.setUserPassword(form.getNewPsw());
        user.setUserAccStatus("UNLOCKED");

        userDtlsRepo.save(user);
    }

}
