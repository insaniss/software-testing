package ru.ifmo.math.trigonometry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ifmo.math.Function;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

public class CotangentTest {
    private static final double EPS = 0.01;

    private Function cot;

    @BeforeEach
    void setUp() {
        this.cot = new Cotangent();
    }

    @ParameterizedTest(name = "value = {0}, result = {1}")
    @CsvFileSource(
            files = "lab-2.0/test/resources/cot.csv",
            numLinesToSkip = 1
    )
    void testWithPointsFromTable(double value, double result) {
        assertEquals(result, cot.apply(value), EPS);
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            2 * PI + PI / 3,
            9 * PI - PI / 8,
            7 * PI + PI / 16,
            3 * PI + PI / 7
    })
    void testWithBigPeriods(double value) {
        assertEquals(1 / tan(value), cot.apply(value), EPS);
    }
}
