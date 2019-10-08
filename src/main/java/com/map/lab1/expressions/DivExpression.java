package com.map.lab1.expressions;

import com.map.lab1.Complex;
import com.map.lab1.operations.Operation;

public class DivExpression extends ComplexExpression {
    public DivExpression(Operation operation, Complex[] complexes) {
        super(operation, complexes);
    }

    @Override
    public Complex executeOneOperation(Complex complexNumber1, Complex complexNumber2) {
        return complexNumber1.division(complexNumber2);
    }
}
