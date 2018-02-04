package tdd_unit.lesson_15_01_18;
//Hello
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static tdd_unit.lesson_15_01_18.Calculator.div;
import static tdd_unit.lesson_15_01_18.Calculator.fact;
import static tdd_unit.lesson_15_01_18.Calculator.mult;

public class CalculatorTest {

    @Test
    @Disabled
    public void multTestIgnored() {
        assertEquals(6, mult(2, 3));
    }

    @ParameterizedTest
    @CsvSource({"1, 0"})
    public void divideOnZero(long in1, long in2) {
        assertThrows(ArithmeticException.class, () -> {
            div(in1, in2);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "0 , 1",
            "2 , 2",
            "3 , 6",
            "4 , 24",
            "5 , 120"
    })
    public void correctFactorialWithParameters(long in, long expect_out) {
        assertEquals(expect_out, fact(in));
    }
}
