package com.Third_Mini_Project.Repo;

import com.Third_Mini_Project.Entity.User;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Repo extends JpaRepository<User,Long> {

    //findByEmail
    public User findByEmail(String email);

    // findByEmailAndPassword
    public User findByEmailAndPassword(String email, String password);

}
