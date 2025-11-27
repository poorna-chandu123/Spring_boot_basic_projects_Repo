package com.curd_operations_testdemo.Services;

import com.curd_operations_testdemo.Entity.Contact;
import com.curd_operations_testdemo.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getContactList() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found for id: " + id));
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

}

