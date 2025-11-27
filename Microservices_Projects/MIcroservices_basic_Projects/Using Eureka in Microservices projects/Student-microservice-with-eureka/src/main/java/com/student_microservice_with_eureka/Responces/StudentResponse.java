package com.student_microservice_with_eureka.Responces;


import com.student_microservice_with_eureka.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentResponse {

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private AddressResponse addressResponse;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }


}


