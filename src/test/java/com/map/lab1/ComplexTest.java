package com.map.lab1;

import com.map.lab1.expressions.ComplexExpression;
import com.map.lab1.expressions.ExpressionParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ComplexTest {
    private ExpressionParser expressionParser;

    @Before
    public void init() {
        expressionParser = new ExpressionParser();
    }
    @Test(expected = RuntimeException.class)
    public void testInvalidExpressionShouldThrowException() {
        expressionParser.parseExpression(new String[]{"25", "+", "+"});
    }

    @Test(expected = RuntimeException.class)
    public void testNotSameOperatorShouldThrowException() {
        expressionParser.parseExpression(new String[]{"1*i", "+", "2", "-", "2"});
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidNumberShouldThrowException(){
        expressionParser.parseExpression(new String[]{"1*u", "+", "2", "+", "2"});
    }

    @Test
    public void complexTestAdd() {
        ComplexExpression complexExpression = expressionParser.parseExpression(new String[]{"1*i", "+", "2", "+", "2"});
        Complex complex = complexExpression.execute();
        assertEquals((Double) 4.0, (Double) complex.getReal());
        assertEquals((Double) 1.0, (Double) complex.getImaginary());
    }

    @Test
    public void complexTestSub() {
        ComplexExpression complexExpression = expressionParser.parseExpression(new String[]{"1*i", "-", "2", "-", "2"});
        Complex complex = complexExpression.execute();
        assertEquals((Double) (-4.0), (Double) complex.getReal());
        assertEquals((Double) 1.0, (Double) complex.getImaginary());
    }

    @Test
    public void complexTestMultiply() {
        ComplexExpression complexExpression = expressionParser.parseExpression(new String[]{"1*i", "*", "2", "*", "2"});
        Complex complex = complexExpression.execute();
        assertEquals((Double) (0.0), (Double) complex.getReal());
        assertEquals((Double) 4.0, (Double) complex.getImaginary());
    }

    @Test
    public void complexTestDivision() {
        ComplexExpression complexExpression = expressionParser.parseExpression(new String[]{"1*i", "/", "1"});
        Complex complex = complexExpression.execute();
        assertEquals((Double) (0.0), (Double) complex.getReal());
        assertEquals((Double) 1.0, (Double) complex.getImaginary());
    }

}
