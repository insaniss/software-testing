package ru.ifmo.math.trigonometry;

import static java.lang.Double.*;
import static java.lang.Math.*;

public class Sine implements TrigonometricFunction {

    /**
     * Returns the sine of an angle; the returned value
     * is in the range -1 through 1. Special cases:
     * <ul><li>If the argument is zero or <i>pi</i>,
     * than the result is 0. <li>If the argument is <i>pi</i>/2,
     * than the result is 1. <li>If the argument is 3<i>pi</i>/2,
     * than the result is -1.</ul>
     *
     * @param value the function argument.
     * @param eps the precision.
     * @return the sine of the argument.
     */
    @Override
    public double apply(double value, double eps) {
        if (isNaN(value) || isInfinite(value)) {
            return NaN;
        }
        /* simplifying the value */
        value = value % (2 * PI);

        double delta, result = 0.0;
        int step = 1, sign = 1;
        do {
            delta = 1;
            /* calc n-th member of the series */
            for (int n = 1; n <= step; n++) {
                delta *= value / n;
            }
            step   +=  2;
            /* add the value to the result */
            result += sign * delta;
            /* change the sign to the opposite */
            sign   *= -1;
        } while (abs(delta) > abs(eps));

        return result;
    }
}
