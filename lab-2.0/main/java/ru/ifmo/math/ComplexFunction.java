package ru.ifmo.math;

import ru.ifmo.math.logarithms.CommonLogarithm;
import ru.ifmo.math.logarithms.NaturalLogarithm;
import ru.ifmo.math.trigonometry.Cotangent;
import ru.ifmo.math.trigonometry.Tangent;

import static java.lang.Math.pow;
import static ru.ifmo.math.logarithms.Base.*;

public class ComplexFunction implements Function {
    private final Function tan, cot;
    private final Function ln, log3, log5, lg;

    public ComplexFunction() {
        this.tan = new Tangent();
        this.cot = new Cotangent();
        this.ln = new NaturalLogarithm();
        this.log3 = new CommonLogarithm(BASE_THREE);
        this.log5 = new CommonLogarithm(BASE_FIVE);
        this.lg = new CommonLogarithm(BASE_TEN);
    }

    @Override
    public double apply(double value, double eps) {
        if (value < 0) {
            return cot.apply(value, eps) + tan.apply(value, eps);
        } else {
            return pow(ln.apply(value, eps) * lg.apply(value, eps)
                    * log5.apply(value, eps) * log3.apply(value, eps)
                    - lg.apply(value, eps) * lg.apply(value, eps), 3);
        }
    }
}
