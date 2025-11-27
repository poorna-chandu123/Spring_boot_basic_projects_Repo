package com.curd_operations_testdemo.Controller;


import com.curd_operations_testdemo.Entity.Contact;
import com.curd_operations_testdemo.Services.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(ContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    @Test
    public void testSaveContact() throws Exception {
        Contact contact = new Contact(1L, "chandu", "poorna", "7032714843");
        when(contactService.saveContact(any(Contact.class))).thenReturn(contact);

        mockMvc.perform(post("/contact/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(status().isOk());

        System.out.println("Test Passed");
    }


    @Test
    public void testSaveContact1() throws Exception {

        Contact contact = new Contact(2L, "kiran", "bro", "9059084525");
        when(contactService.saveContact(contact)).thenReturn(contact);

        mockMvc.perform(post("/contact/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(status().isOk());
        System.out.println("Test Passed");

    }

    // test case get contact by id
    @Test
    public void testGetContactById1() throws Exception {
        Contact contact = new Contact(1L, "chandu", "poorna", "7032714843");
        when(contactService.getContactById(1L)).thenReturn(contact);

        mockMvc.perform(get("/contact/get/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("chandu")); // Ensure JSON key matches response
        System.out.println("Test Passed get contact by id ");

    }
}



