package com.curd_operations_testdemo.Services;


import com.curd_operations_testdemo.Entity.Contact;
import com.curd_operations_testdemo.Repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ContactService_Test {

    @MockBean
    private ContactRepository contactRepository;

    @Autowired
    private ContactService contactService;

    // test method for save contact
    @Test
    public void test_SaveContact() {
        Contact contact = new Contact(1L, "chandu", "poorna", "7032714843");
        when(contactRepository.save(any(Contact.class))).thenReturn(contact);
        assertEquals(contact, contactRepository.save(contact));

        System.out.println("Test Passed for save contact");
    }

    // test method for get contact by id
    @Test
    public void test_GetContactById() {
        Contact contact = new Contact(2L, "kiran", "poorna", "7032714843");
        when(contactRepository.findById(2L)).thenReturn(Optional.of(contact));
          // validate with mobile number
        assertEquals("7032714843", contactRepository.findById(2L).get().getPhoneNumber());

        System.out.println("Test Passed for get contact by id");
    }
}
