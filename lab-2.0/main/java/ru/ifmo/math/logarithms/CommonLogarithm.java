package ru.ifmo.math.logarithms;

public class CommonLogarithm implements Logarithm {
    private final Logarithm ln;
    private final Base base;

    public CommonLogarithm(Base base) {
        this.base = base;
        this.ln = new NaturalLogarithm();
    }

    @Override
    public double apply(double value, double eps) {
        return ln.apply(value, eps) / ln.apply(base.value(), eps);
    }
}
