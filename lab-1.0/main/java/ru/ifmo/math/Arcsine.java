package ru.ifmo.math;

import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;
import static java.lang.Math.abs;

public class Arcsine implements Function {
    /**
     * Returns the arc sine of a value; the returned angle is in the
     * range -<i>pi</i>/2 through <i>pi</i>/2. Special cases:
     * <ul><li>If the argument is <i>NaN</i> or its absolute value is
     * greater than 1, then the result is <i>NaN</i>.
     * <li>If the argument is zero, then the result is a zero with the
     * same sign as the argument.</ul>
     *
     *
     * @param value the function argument.
     * @param eps the precision.
     * @return the arc sine of the argument.
     */
    @Override
    public double apply(double value, double eps) {
        if (isNaN(value) || abs(value) > 1.0) {
            return NaN;
        }
        if (isNaN(eps) || abs(eps) > 1E-6) {
            throw new IllegalArgumentException("Precision too large (or NaN)");
        }
        double result = 0.0, delta = value;
        int step = 0; value *= value;
        do {
            result = result + delta;
            delta = calculateSeriesMember(delta, value, step);
            step = step + 1;
        } while (abs(delta) >= eps);

        return result;
    }

    private double calculateSeriesMember(double a, double x, double n) {
        return a * x * (n + 0.5) / (n + 1.0) * (n + 0.5) / (n + 1.5);
    }
}
