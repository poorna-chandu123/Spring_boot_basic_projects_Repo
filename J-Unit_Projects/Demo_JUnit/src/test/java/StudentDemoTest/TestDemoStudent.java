package StudentDemoTest;

import org.example.StudentJUnitDemo.StudentDummyRepo;
import org.powermock.api.mockito.PowerMockito;


import org.example.StudentJUnitDemo.StudentDummyServices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDemoStudent {

    @Test
    public void testDemoStudent() {

        StudentDummyRepo dummyRep = PowerMockito.mock(StudentDummyRepo.class);

        PowerMockito.when(dummyRep.findbyname(1)).thenReturn("kiran");
        StudentDummyServices studentDummyServices = new StudentDummyServices(dummyRep);
        String actualValue = studentDummyServices.findby_name(1);
        assertEquals("kiran", actualValue);
        System.out.println("Test Passed");

    }


    @Test
    public void testDemoStudent1() {

        StudentDummyRepo dummyRep = PowerMockito.mock(StudentDummyRepo.class);

        PowerMockito.when(dummyRep.findbyEmailID("chandu")).thenCallRealMethod();
        StudentDummyServices studentDummyServices = new StudentDummyServices(dummyRep);
        String actualValue = studentDummyServices.findby_EmailID("chandu");
        assertEquals("kiran@gmail.com", actualValue);
        System.out.println("Test Passed");

    }



}
