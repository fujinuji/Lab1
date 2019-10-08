package com.map.lab1;

import com.map.lab1.expressions.*;
import com.map.lab1.operations.Operation;

public class ExpressionFactory {

    public ExpressionFactory getInstance() {
        return this.getInstance();
    }

    public ComplexExpression createExpression(Operation operation, Complex[] complexes) {
        switch (operation) {
            case ADD:
                return new AdditionExpression(operation, complexes);
            case DIVISION:
                return new DivExpression(operation, complexes);
            case MULTIPLY:
                return new MultiplyExpression(operation, complexes);
            case SUBTRACTION:
                return new SubstractOperation(operation, complexes);
        }

        return null;
    }
}
