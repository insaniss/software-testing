package ru.ifmo.math.trigonometry;

import static java.lang.Math.PI;

public class Cosine implements TrigonometricFunction {
    private final TrigonometricFunction sin;

    public Cosine() {
        this.sin = new Sine();
    }

    /**
     * Returns the sine of an angle; the returned value
     * is in the range -1 through 1. Special cases:
     * <ul><li>If the argument is zero, than the result is 1.
     * <li>If the argument is <i>pi</i>/2 or 3<i>pi</i>/2,
     * than the result is 0. <li>If the argument is <i>pi</i>,
     * than the result is -1.</ul>
     *
     * @param value the function argument.
     * @param eps the precision.
     * @return the cosine of the argument.
     */
    @Override
    public double apply(double value, double eps) {
        return sin.apply(value + PI / 2, eps);
    }
}
