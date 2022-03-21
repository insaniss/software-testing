package ru.ifmo.math.logarithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.ifmo.math.Function;

import static org.junit.jupiter.api.Assertions.*;
import static ru.ifmo.math.logarithms.Base.*;

public class CommonLogarithmTest {
    private static final double EPS = 1E-3;

    private Function log;
    private Function log3;
    private Function log5;
    private Function lg;

    @BeforeEach
    void setUp() {
        this.log = new CommonLogarithm(BASE_TWO);
        this.log3 = new CommonLogarithm(BASE_THREE);
        this.log5 = new CommonLogarithm(BASE_FIVE);
        this.lg = new CommonLogarithm(BASE_TEN);
    }

    @ParameterizedTest(name = "value = {0}, log(x) = {1}, log3(x) = {2}, log5(x) = {3}, lg(x) = {4}")
    @CsvFileSource(
            files = "lab-2.0/test/resources/log.csv",
            numLinesToSkip = 1
    )
    void testWithPointsFromTable(double value, double log, double log3, double log5, double lg) {
        assertAll(
            () -> assertEquals(log, this.log.apply(value), EPS),
            () -> assertEquals(log3, this.log3.apply(value), EPS),
            () -> assertEquals(log5, this.log5.apply(value), EPS),
            () -> assertEquals(lg, this.lg.apply(value), EPS)
        );
    }
}
