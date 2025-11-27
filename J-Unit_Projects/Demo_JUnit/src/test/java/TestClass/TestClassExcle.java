package TestClass;

import org.example.EvenOrOddExcle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassExcle {

    @ParameterizedTest
    @CsvFileSource(resources = "/TestExcleFile.csv", numLinesToSkip = 1)
    // @CsvFileSource is used to read data from a CSV file.
            public void testEvenOrOddExcle(int input, String expectedvalue) {
        EvenOrOddExcle evenOrOddExcle = new EvenOrOddExcle();
        String result = evenOrOddExcle.evenOrOddExcle(input);
        assertEquals(expectedvalue, result);
    }

    @ParameterizedTest
    @CsvSource({"2,even", "3,odd", "4,even", "6,odd"})
    // @CsvSource is used to provide a single CSV row as an input to a test method.
    public void testEvenOrOddExcle1(int input, String expectedvalue) {
        EvenOrOddExcle evenOrOddExcle = new EvenOrOddExcle();
        String result = evenOrOddExcle.evenOrOddExcle(input);
        assertEquals(expectedvalue, result);
    }
}
