package ru.ifmo.math.logarithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.ifmo.math.Function;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryLogarithmTest {
    private static final double EPS = 1E-3;

    private Function log;

    @BeforeEach
    void setUp() {
        this.log = new BinaryLogarithm();
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "lab-2.0/test/resources/lg.csv",
            numLinesToSkip = 1
    )
    void testWithPointsFromTable(double value, double result) {
        assertEquals(result, log.apply(value), EPS);
    }
}
