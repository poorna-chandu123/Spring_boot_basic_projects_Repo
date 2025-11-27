package com.curd_operations_testdemo.Repository;

import com.curd_operations_testdemo.Entity.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
public class ContactRepository_Test {

    @Autowired
    private ContactRepository contactRepository;

    private Contact contact;

    @BeforeEach
    public void setContact() {
        contact = new Contact(13L,"chandu", "poorna", "7032714843"); // ✅ Assigns to instance variable
         contactRepository.save(contact);
    }

    @AfterEach
    void tearDown() {
        contact = null;
        contactRepository.deleteAll();
    }

    @Test
    public void testFindByFirstName() {
        List<Contact> contactList = contactRepository.findByFirstName("chandu");
        assertNotNull(contactList);
        assertFalse(contactList.isEmpty()); // ✅ Ensures list is not empty before accessing elements

        assertEquals("chandu", contactList.get(0).getFirstName());
        assertThat(contactList.get(0).getPhoneNumber()).isEqualTo(contact.getPhoneNumber());
        assertNotEquals("343223", contactList.get(0).getPhoneNumber());

        System.out.println("Test Passed find by first name");
    }
}
