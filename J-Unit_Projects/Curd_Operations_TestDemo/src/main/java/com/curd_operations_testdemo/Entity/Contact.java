package com.curd_operations_testdemo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Commented out to avoid auto-generation of id for testing purposes
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    //setters and getters

}

