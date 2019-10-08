package com.map.lab1;

import com.map.lab1.expressions.ComplexExpression;
import com.map.lab1.expressions.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        ExpressionParser expressionParser = new ExpressionParser();
        ComplexExpression complexExpression = expressionParser.parseExpression(args);
        System.out.printf(complexExpression.execute().toString());
    }
}
