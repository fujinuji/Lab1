package com.map.lab1.expressions;

import com.map.lab1.Complex;
import com.map.lab1.operations.Operation;

public abstract class ComplexExpression {

    private Operation operation;
    private Complex[] complexes;

    public abstract Complex executeOneOperation(Complex complexNumber1, Complex complexNumber2);

    public ComplexExpression(Operation operation, Complex[] complexes) {
        this.operation = operation;
        this.complexes = complexes;
    }

    public Complex execute() {
        Complex result;
        if (complexes.length > 1) {
            result = executeOneOperation(complexes[0], complexes[1]);

            for (int i = 2; i < complexes.length; ++i) {
                result = executeOneOperation(result, complexes[i]);
            }

        } else {
            result = complexes[0];
        }

        return result;
    }

    @Override
    public String toString() {
        String complexExpresssion = "";
        for (Complex complex : complexes) {
            complexExpresssion += complex + this.operation.name();
        }

        return complexExpresssion.substring(0, complexExpresssion.length() - 1);
    }
}
