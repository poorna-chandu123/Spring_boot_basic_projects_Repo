package TestClass;

import org.example.StringDemo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringDemoTestClass {


    StringDemo stringDemo = new StringDemo();
    @Test
    public void testStringToInt() {
      //  StringDemo stringDemo = new StringDemo();
        int result = stringDemo.stringToInt("");
        assertEquals(123, result);
        System.out.println("Test Passed");
    }

    @Test
    public void test2() {
      //  StringDemo stringDemo = new StringDemo();
        int result = stringDemo.stringToInt("1");
        assertEquals(1, result);
        System.out.println("Test Passed");
    }

    @Test
    public void test3() {

        assertThrows(IllegalArgumentException.class, () -> {
            stringDemo.stringToInt("  ");
        });
        System.out.println("Test Passed");
    }


    // multiple test cases rayakunda e Annotation use cheyochu
    @ParameterizedTest
        @ValueSource (strings = {"1", "2", "3", "4", "5"})
    public void test4(String str) {
        StringDemo stringDemo1 = new StringDemo();
        int result = stringDemo1.stringToInt(str);
        assertEquals(Integer.parseInt(str), result);
        System.out.println("Test Passed");
    }

}
