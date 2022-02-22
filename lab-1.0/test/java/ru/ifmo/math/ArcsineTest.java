package ru.ifmo.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Double.NaN;
import static java.lang.Math.abs;
import static java.lang.Math.asin;
import static org.junit.jupiter.api.Assertions.*;

class ArcsineTest {
    private static final Function arcsine = new Arcsine();

    private static boolean almostEquals(double x, double y) {
        return abs(x - y) <= 1e-3;
    }

    @ParameterizedTest(name = "epsilon = {0}")
    @ValueSource(doubles = {
            -6.20452,
             0.12365,
             1.00251,
             9.99999, NaN
    })
    void testWithInvalidPrecisions(double eps) {
        assertThrows(IllegalArgumentException.class, () -> {
            arcsine.apply(0, eps);
        });
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            -5.09234,
            -1.00001,
             2.23454,
             9.24355, NaN
    })
    void testWithInacceptableRangePoints(double value) {
        assertEquals(NaN, arcsine.apply(value));
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            -0.99923,
            -0.45893,
            -0.10034,
             0.13241,
             0.32459,
             0.07549,
    })
    void testWithAcceptableRangePoints(double value) {
        assertTrue(almostEquals(asin(value), arcsine.apply(value)));
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            -1.00000,
             0.00000,
             1.00000,
    })
    void testWithCriticalPoints(double value) {
        assertTrue(almostEquals(asin(value), arcsine.apply(value)));
    }
}
