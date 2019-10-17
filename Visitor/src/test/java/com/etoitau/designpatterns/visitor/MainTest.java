package com.etoitau.designpatterns.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void expressionPrinterTest() {
        AdditionExpression aexp;
        MultiplicationExpression mexp;
        ExpressionPrinter ep;
        String expected;

        aexp = new AdditionExpression(new Value(2), new Value(3));
        expected = "(2+3)";
        ep = new ExpressionPrinter();
        ep.visit(aexp);
        assertEquals(expected, ep.toString());

        mexp = new MultiplicationExpression(
                new Value(2),
                new AdditionExpression(new Value(-1), new Value(3))
        );
        expected = "2*(-1+3)";
        ep = new ExpressionPrinter();
        ep = new ExpressionPrinter();
        ep.visit(mexp);
        assertEquals(expected, ep.toString());
    }
}