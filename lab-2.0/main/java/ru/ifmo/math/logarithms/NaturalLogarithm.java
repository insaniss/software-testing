package ru.ifmo.math.logarithms;

import static java.lang.Double.*;
import static java.lang.Math.*;

public class NaturalLogarithm implements Logarithm {
    /**
     * Returns the natural logarithm of a value; the returned value
     * is in the range -<i>inf</i> through <i>inf</i>. Special cases:
     * <ul><li>If the argument is <i>NaN</i> or less than 0,
     * then the result is <i>NaN</i>. <li>If the argument is one,
     * then the result is a zero. <li>If the argument is <i>inf</i>,
     * then the result is a <i>inf</i>.</ul>
     *
     * @param value the function argument.
     * @param eps the precision.
     * @return the natural logarithm of the argument.
     */
    @Override
    public double apply(double value, double eps) {
        if (isNaN(value) || value <= 0) {
            return NaN;
        }
        if (isInfinite(value)) {
            return POSITIVE_INFINITY;
        }
        if (isNaN(eps) || abs(eps) > 1E-6) {
            throw new IllegalArgumentException("Precision too large (or NaN)");
        }

        double delta, result = 0.0;
        double number = (value - 1) / (value + 1);
        int step = 1;
        do {
            delta = 2 * pow(number, step) / step;
            step   += 2;
            result += delta;
        } while (abs(delta) >= abs(eps));

        return result;
    }
}
