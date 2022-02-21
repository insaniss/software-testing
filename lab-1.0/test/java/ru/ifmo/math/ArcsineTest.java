package ru.ifmo.math;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Double.NaN;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArcsineTest {
    private static Function arcsine;

    private static boolean almostEquals(double x, double y) {
        return abs(x - y) < 1e-3;
    }

    @BeforeAll
    public static void init() {
        arcsine = new Arcsine();
    }

    @Test
    public void test0() {
        assertThrows(IllegalArgumentException.class, () -> arcsine.apply(0, NaN));
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            -1.00000,
             0.00000,
             1.00000
    })
    public void test1(double value) {
        assertTrue(almostEquals(asin(value), arcsine.apply(value)));
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            -0.99923,
            -0.45893,
            -0.10034,
             0.13241,
             0.32450,
             0.07549
    })
    public void test2(double value) {
        assertTrue(almostEquals(asin(value), arcsine.apply(value)));
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            -5.09234,
            -1.00001,
             2.23454,
             9.24355,
             NaN
    })
    public void test3(double value) {
        assertEquals(NaN, arcsine.apply(value));
    }
}