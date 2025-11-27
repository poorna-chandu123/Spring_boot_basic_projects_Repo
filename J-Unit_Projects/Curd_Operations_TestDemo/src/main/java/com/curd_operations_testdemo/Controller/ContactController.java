package com.curd_operations_testdemo.Controller;



import com.curd_operations_testdemo.Entity.Contact;
import com.curd_operations_testdemo.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/contact")
public class  ContactController {

    @Autowired
    private ContactService contactService;

    // post mappinf for save contact
    @PostMapping("/save")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.saveContact(contact));
    }

    // get mapping for get all contact
    @GetMapping("/get")
    public ResponseEntity<List<Contact>> getAllContact() {
        return ResponseEntity.ok(contactService.getContactList());
    }

    // get mapping for get contact by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    //delete by id
    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

}
