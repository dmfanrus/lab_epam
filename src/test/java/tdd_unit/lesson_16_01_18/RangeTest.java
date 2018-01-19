package tdd_unit.lesson_16_01_18;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

    Range range1;
    Range range2;
    Range range3;

    private static int testId = 0;

    @BeforeEach
    void setUp() {
        range1 = new Range(1, 5);
        range2 = new Range(6, 9);
        range3 = new Range(4, 7);
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
    void isBefore() {
        assertTrue(range1.isBefore(range2));
        assertFalse(range2.isBefore(range1));
    }

    @Test
    void isAfter() {
        assertFalse(range1.isAfter(range2));
        assertTrue(range2.isAfter(range1));
    }

    @Test
    void isConcurrent() {
        assertTrue(range1.isConcurrent(range3));
        assertFalse(range1.isConcurrent(range2));
    }

    @ParameterizedTest
    @CsvSource({"1,6,4"})
    void getLowerBound(int lower1, int lower2, int lower3) {
        assertAll("all lowers",
                () -> assertEquals(lower1, range1.getLowerBound()),
                () -> assertEquals(lower2, range2.getLowerBound()),
                () -> assertEquals(lower3, range3.getLowerBound())
        );
    }

    @ParameterizedTest
    @CsvSource({"5,9,7"})
    void getUpperBound(int upper1, int upper2, int upper3) {
        assertAll("all uppers",
                () -> assertEquals(upper1, range1.getUpperBound()),
                () -> assertEquals(upper2, range2.getUpperBound()),
                () -> assertEquals(upper3, range3.getUpperBound())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void valuesContains(int value) {
        assertTrue(range1.contains(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 6})
    void valuesNotContains(int value) {
        assertFalse(range1.contains(value));
    }

    @Test
    void asListTest() {
        assertEquals(asList(1L, 2L, 3L, 4L, 5L), range1.asList());
    }

    //@Disabled work with @ParametrizedTest but wrong. If they use together, then print "Empty test suite"
    @Disabled
    @Test
    void asListTestIgnored() {
        assertEquals(asList(1L, 2L, 3L, 4L, 5L), range1.asList());
    }

    @Test
    void asIterator() {
        assertIterableEquals(asList(1L, 2L, 3L, 4L, 5L), range1.asList());
    }
}
