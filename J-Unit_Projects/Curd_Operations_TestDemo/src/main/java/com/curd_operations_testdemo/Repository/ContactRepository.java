package com.curd_operations_testdemo.Repository;

import com.curd_operations_testdemo.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByFirstName(String firstName);

}

