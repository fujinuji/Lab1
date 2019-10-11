package com.map.lab1.expressions;

import com.map.lab1.Complex;
import com.map.lab1.ExpressionFactory;
import com.map.lab1.operations.Operation;
import com.map.lab1.utils.Constants;

import java.util.ArrayList;
import java.util.List;


public class ExpressionParser {
    private ExpressionFactory expressionFactory = ExpressionFactory.getInstance();

    public ComplexExpression parseExpression(String[] expressionString) {
        if (!isValid(expressionString)) {
            throw new RuntimeException("Invalid expression");
        }

        if (expressionString.length > 1) {
            return expressionFactory.createExpression(Operation.value(expressionString[1]), buildArgs(expressionString));
        }

        return expressionFactory.createExpression(Operation.ADD, buildArgs(expressionString));
    }

    public boolean isValid(String[] complexExpression) {

        if (complexExpression.length / 2 != 0) {
            return false;
        }
        //Check if operators are valid
        for (int index = 1; index < complexExpression.length; index += 2) {
            if (!complexExpression[index].matches(Constants.OPERATOR_REGEX)) {
                return false;
            }
        }

        //Check if the expression has the same operator
        if (complexExpression.length > 1) {
            String operator = complexExpression[1];

            for (int index = 1; index < complexExpression.length; index += 2) {
                if (!operator.equals(complexExpression[index])) {
                    return false;
                }
            }
        }

        for (int index = 0; index < complexExpression.length; index += 2) {
            if (!complexExpression[index].matches(Constants.COMPLEX_NUMBER_REGEX)) {
                return false;
            }
        }

        return true;
    }

    private Complex[] buildArgs(String[] complexExpression) {
        List<Complex> complexList = new ArrayList<>();

        for (int index = 0; index < complexExpression.length; index += 2) {
            boolean sign = false;
            boolean signReal = false;

            if ('-' == complexExpression[index].charAt(0)) {
                if(complexExpression[index].matches(Constants.COMPLEX_NUMBER_IMAGINARY_REGEX)) {
                    sign = true;
                } else {
                    signReal = true;
                }

                complexExpression[index] = complexExpression[index].substring(complexExpression[index].indexOf('-') + 1);
            }

            if (complexExpression[index].contains("-")) {
                sign = true;
            }

            String[] complexNumberParts = complexExpression[index].split(Constants.COMPLEX_NUMBER_OPERATOR_REGEX);

            String real = "0", imaginary = "0";

            for (String number : complexNumberParts) {
                if (number.contains("i")) {
                    if (number.equals("i")) {
                        imaginary = (sign ? "-" : "+") + "1";
                    } else  {
                        imaginary = (sign ? "-" : "+") + number.replace("*i", "");
                    }
                } else {
                    real = (signReal ? "-" : "+") + number;
                }
            }

            complexList.add(new Complex(Double.parseDouble(real), Double.parseDouble(imaginary)));
        }

        Complex[] complexes = new Complex[complexList.size()];
        int complexIndex = 0;

        for (Complex complex : complexList) {
            complexes[complexIndex] = complex;
            complexIndex++;
        }
        return complexes;
    }
}
