package com.map.lab1;

import com.map.lab1.expressions.ComplexExpression;
import com.map.lab1.expressions.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        ExpressionParser expressionParser = new ExpressionParser();
        ComplexExpression complexExpression;
        try {
            complexExpression = expressionParser.parseExpression(args);
            System.out.print(complexExpression.execute().toString());
        } catch (RuntimeException ex) {
            System.out.printf(ex.getMessage());
        }
    }
}
