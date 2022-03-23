package ru.ifmo.math.trigonometry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ifmo.math.Function;

import static java.lang.Double.*;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

public class SineTest {
    private static final double EPS = 0.01;

    private Function sin;

    @BeforeEach
    void setUp() {
        this.sin = new Sine();
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "lab-2.0/test/resources/sin.csv",
            numLinesToSkip = 1
    )
    void testWithPointFromTable(double value, double result) {
        assertEquals(result, sin.apply(value), EPS);
    }

    @ParameterizedTest(name = "epsilon = {0}")
    @ValueSource(doubles = {
           -3.141592,
            0.035544,
            0.000345,
            9.993595, NaN
    })
    void testWithInvalidPrecision(double eps) {
        assertThrows(IllegalArgumentException.class, () -> sin.apply(0, eps));
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            2 * PI + PI / 3,
            9 * PI - PI / 8,
            7 * PI + PI / 16,
            3 * PI + PI / 7
    })
    void testWithBigPeriods(double value) {
        assertEquals(sin(value), sin.apply(value), EPS);
    }
}
