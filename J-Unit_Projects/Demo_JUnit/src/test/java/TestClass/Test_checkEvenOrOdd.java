package TestClass;

import org.example.CheckEverOrOdd;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Test_checkEvenOrOdd {


    CheckEverOrOdd checkEverOrOdd = new CheckEverOrOdd();

    @Test
    public void test1() {
        boolean b = checkEverOrOdd.EvenOrOdd(4);
        assertTrue(b);

    }

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8})
    public void test2(int num) {
        boolean b = checkEverOrOdd.EvenOrOdd(num);
        assertTrue(b);

    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,4,7})
    public void test3(int num) {
        boolean b = checkEverOrOdd.EvenOrOdd(num);
        assertTrue(b);

    }

    @ParameterizedTest
    @MethodSource("provideData")  // E anotation ni use chesthe oka method ni use chesi multiple
                                      // values positive and negative test cases ni test cheyochu
    @Disabled
    public void test4(int num, boolean expected) {
        boolean b = checkEverOrOdd.EvenOrOdd(num);
        assertEquals(expected,b);

    }

    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(2,true),
                Arguments.of(3,true),
                Arguments.of(6,true),
                Arguments.of(8,true)
        );
    }
    @Test
    @RepeatedTest(value = 2) // value = 2 ante 2 times run avuthundi
    public void test5() {
        boolean b = checkEverOrOdd.EvenOrOdd(4);
        assertTrue(b);
        System.out.println("Test5 Passed");

    }


}
