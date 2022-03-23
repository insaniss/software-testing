package ru.ifmo.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexFunctionTest {
    private static final double EPS = 0.01;

    private Function function;

    @BeforeEach
    void setUp() {
        this.function = new ComplexFunction();
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "lab-2.0/test/resources/data.csv",
            numLinesToSkip = 1
    )
    void testWithPointsFromTable(double value, double result) {
        assertEquals(result, function.apply(value), EPS);
    }
}
