package org.example.StudentJUnitDemo;

public class StudentDummyServices {

    private StudentDummyRepo studentDummyRepo;

    //no-arg constructor
    public StudentDummyServices() {
       super();
    }

    //parameterized constructor
    public StudentDummyServices(StudentDummyRepo studentDummyRepo) {
        super();
        this.studentDummyRepo = studentDummyRepo;
    }

    // findbyname method
    public String findby_name(int id ) {
        return studentDummyRepo.findbyname(id);
    }
    // findbyEmailID method
    public String findby_EmailID(String name ) {
        return studentDummyRepo.findbyEmailID(name);
    }
}
