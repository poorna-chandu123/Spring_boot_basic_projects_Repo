package com.second_mini_project.Repo;

import com.second_mini_project.Entity.UserDtlsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity, Integer> {

    // add custom method to find user by email
    public UserDtlsEntity findByUserEmail(String email);

    // add custom method to find user by email and password for login validation
    public UserDtlsEntity findByUserEmailAndUserPassword(String email, String psw);
}
