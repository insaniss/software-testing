package ru.ifmo.math.trigonometry;

public class Tangent implements TrigonometricFunction {
    private final TrigonometricFunction sin;
    private final TrigonometricFunction cos;

    public Tangent() {
        this.sin = new Sine();
        this.cos = new Cosine();
    }

    /**
     * Returns the tangent of an angle; the returned value
     * is in range -<i>inf</i> through <i>inf</i>: Special cases:
     * <ul><li>If the argument is zero, than the result is 0.
     * <li>If the argument is <i>pi</i>/4, than the result is 1.
     * <li>If the argument is <i>pi</i>/2, than the result is <i>inf</i>.
     * <li>If the argument is 3<i>pi</i>/4, than the result is -1.</ul>
     *
     * @param value the function argument.
     * @param eps the precision.
     * @return the tangent of the argument.
     */
    @Override
    public double apply(double value, double eps) {
        return sin.apply(value, eps) / cos.apply(value, eps);
    }
}
