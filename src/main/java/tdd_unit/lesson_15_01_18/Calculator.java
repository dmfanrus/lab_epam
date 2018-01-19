package tdd_unit.lesson_15_01_18;

public class Calculator {
    public static long mult(long first, long second) {
        return first * second;
    }

    public static long div(long first, long second) {
        return first / second;
    }

    public static long fact(long num) {
        if (num < 0) {
            throw new IllegalArgumentException("The argument must be greater than 0 or equal to 0");
        }
        if (num <= 1) return 1;
        return num * fact(num - 1);
    }
}
