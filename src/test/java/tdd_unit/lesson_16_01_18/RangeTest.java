package tdd_unit.lesson_16_01_18;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

    private Range range_1_5;
    private Range range_6_9;
    private Range range_4_7;
    private Range range_5_6;

    private static int testId = 0;

    @BeforeEach
    void setUp() {
        range_1_5 = new Range(1, 5);
        range_6_9 = new Range(6, 9);
        range_4_7 = new Range(4, 7);
        range_5_6 = new Range(5, 6);
    }

    @AfterEach
    void eachTest() {
        testId += 1;
        System.out.println("End of test " + testId);
    }

    @AfterAll
    static void endAllTests() {
        System.out.println("End of all tests");
    }

    //Tests for Range
    @Test
    void isBeforeTest() {
        assertTrue(range_1_5.isBefore(range_6_9));
        assertFalse(range_6_9.isBefore(range_1_5));
        assertFalse(range_6_9.isBefore(range_5_6));
        assertFalse(range_5_6.isBefore(range_6_9));
    }

    @Test
    void isAfterTest() {
        assertTrue(range_6_9.isAfter(range_1_5));
        assertFalse(range_1_5.isAfter(range_6_9));
        assertFalse(range_1_5.isAfter(range_5_6));
        assertFalse(range_5_6.isAfter(range_1_5));
    }

    @Test
    void isConcurrentTest() {
        assertTrue(range_1_5.isConcurrent(range_4_7));
        assertFalse(range_1_5.isConcurrent(range_6_9));
        assertTrue(range_1_5.isConcurrent(range_5_6));
    }

    @ParameterizedTest
    @CsvSource({"1,6,4,5"})
    void getLowerBoundTest(int lower_1_5, int lower_6_9, int lower_4_7, int lower_5_6) {
        assertAll("all lowers are equals",
                () -> assertEquals(lower_1_5, range_1_5.getLowerBound()),
                () -> assertEquals(lower_6_9, range_6_9.getLowerBound()),
                () -> assertEquals(lower_4_7, range_4_7.getLowerBound()),
                () -> assertEquals(lower_5_6, range_5_6.getLowerBound())
        );

        assertAll("this lowers are not equals",
                () -> assertNotEquals(lower_6_9, range_1_5.getLowerBound()),
                () -> assertNotEquals(lower_1_5, range_6_9.getLowerBound())
        );
    }

    @ParameterizedTest
    @CsvSource({"5,9,7,6"})
    void getUpperBoundTest(int upper_1_5, int upper_6_9, int upper_4_7, int upper_5_6) {
        assertAll("all uppers are equals",
                () -> assertEquals(upper_1_5, range_1_5.getUpperBound()),
                () -> assertEquals(upper_6_9, range_6_9.getUpperBound()),
                () -> assertEquals(upper_4_7, range_4_7.getUpperBound()),
                () -> assertEquals(upper_5_6, range_5_6.getUpperBound())
        );

        assertAll("all uppers are not equals",
                () -> assertNotEquals(upper_5_6, range_6_9.getUpperBound()),
                () -> assertNotEquals(upper_6_9, range_5_6.getUpperBound())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void valuesContains(int value) {
        assertTrue(range_1_5.contains(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 6})
    void valuesNotContains(int value) {
        assertFalse(range_1_5.contains(value));
    }

    @Test
    void asListTest() {
        assertEquals(asList(1L, 2L, 3L, 4L, 5L), range_1_5.asList());
        assertNotEquals(asList(1L, 2L, 3L, 4L, 5L, 6L), range_1_5.asList());
    }

    @Disabled
    @Test
    void asListTestIgnored() {
        assertEquals(asList(1L, 2L, 3L, 4L, 5L), range_1_5.asList());
    }

    @Test
    void asIteratorTest() {
        assertIterableEquals(asList(1L, 2L, 3L, 4L, 5L), range_1_5.asList());

        Iterator<Long> myIterator = range_1_5.asIterator();
        assertTrue(myIterator.hasNext());
        if(myIterator.hasNext()) {
            long value = myIterator.next();
            assertEquals(1,value);
        }

    }
}
