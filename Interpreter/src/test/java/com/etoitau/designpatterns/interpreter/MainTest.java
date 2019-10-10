package com.etoitau.designpatterns.interpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void calculateTest() {
        ExpressionProcessor ep = new ExpressionProcessor();
        String in;
        int expected;

        in = "1+2+3";
        expected = 6;
        assertEquals(expected, ep.calculate(in));

        in = "1+2+xy";
        expected = 0;
        assertEquals(expected, ep.calculate(in));

        ep.variables.put('x', 3);
        in = "10-2-x";
        expected = 5;
        assertEquals(expected, ep.calculate(in));

        in = "1+2+y";
        expected = 0;
        assertEquals(expected, ep.calculate(in));

        in = "+1 - 2 - x";
        expected = -4;
        assertEquals(expected, ep.calculate(in));

        in = "+1 - - x";
        expected = 0;
        assertEquals(expected, ep.calculate(in));

        in = "-13";
        expected = -13;
        assertEquals(expected, ep.calculate(in));

        in = "";
        expected = 0;
        assertEquals(expected, ep.calculate(in));

        in = "2";
        expected = 2;
        assertEquals(expected, ep.calculate(in));
    }
}