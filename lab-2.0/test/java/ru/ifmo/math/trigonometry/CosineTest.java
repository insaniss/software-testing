package ru.ifmo.math.trigonometry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ifmo.math.Function;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

public class CosineTest {
    private static final double EPS = 0.01;

    private Function cos;

    @BeforeEach
    void setUp() {
        this.cos = new Cosine();
    }

    @ParameterizedTest(name = "value = {0}, result = {0}")
    @CsvFileSource(
            files = "lab-2.0/test/resources/cos.csv",
            numLinesToSkip = 1
    )
    void testWithPointsFromTable(double value, double result) {
        assertEquals(result, cos.apply(value), EPS);
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            2 * PI + PI / 3,
            9 * PI - PI / 8,
            7 * PI + PI / 16,
            3 * PI + PI / 7
    })
    void testWithBigPeriods(double value) {
        assertEquals(cos(value), cos.apply(value), EPS);
    }
}
