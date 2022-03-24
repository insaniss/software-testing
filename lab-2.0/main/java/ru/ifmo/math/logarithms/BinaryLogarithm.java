package ru.ifmo.math.logarithms;

public class BinaryLogarithm implements Logarithm {
    private final CommonLogarithm log;

    public BinaryLogarithm() {
        this.log = new CommonLogarithm(Base.BASE_TWO);
    }

    @Override
    public double apply(double value, double eps) {
        return log.apply(value, eps);
    }
}
