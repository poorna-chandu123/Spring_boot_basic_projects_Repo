package TestClass;

import org.example.AddNub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTestClass {

    @Test
    public void   testAdd() {
        AddNub addNub = new AddNub();
        int result = addNub.testAdd(2, 3);
        assertEquals(5, result);
        System.out.println("Test Passed");

    }

    @Test
    public void testAdd2() {
        AddNub addNub = new AddNub();
        int result = addNub.testAdd(2, 3);
        assertEquals(5, result);
        System.out.println("Test Passed");


    }
}
