package ru.ifmo.math;

/**
 * Represents a function that accepts one argument
 * and produces a result.
 */
public interface Function {
    /**
     * Applies this function to the given argument
     * with the given precision.
     *
     * @param value the function argument.
     * @param eps the precision.
     * @return the function result.
     */
    double apply(double value, double eps);

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument.
     * @return the function result.
     */
    default double apply(double value) {
        return apply(value, 1E-18);
    }
}
