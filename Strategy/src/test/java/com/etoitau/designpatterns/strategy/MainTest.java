package com.etoitau.designpatterns.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Double.NaN;

/**
 * junit5
 */
class MainTest {

    @Test
    void ordinaryDescriminantStrategyTest() {
        OrdinaryDiscriminantStrategy ods = new OrdinaryDiscriminantStrategy();
        double a, b, c, expected, result;


        a = 1;
        b = -1;
        c = -6;
        expected = 25;
        result = ods.calculateDiscriminant(a, b, c);
        assertEquals(expected, result);

        a = 1;
        b = -2;
        c = 5;
        expected = -16;
        result = ods.calculateDiscriminant(a, b, c);
        assertEquals(expected, result);


    }

    @Test
    void realDescriminantStrategyTest() {
        RealDiscriminantStrategy rds = new RealDiscriminantStrategy();
        double a, b, c, expected, result;

        a = 1;
        b = -1;
        c = -6;
        expected = 25;
        result = rds.calculateDiscriminant(a, b, c);
        assertEquals(expected, result);

        a = 1;
        b = -2;
        c = 5;
        expected = NaN;
        result = rds.calculateDiscriminant(a, b, c);
        assertEquals(expected, result);
    }

    @Test
    void solveTest() {
        OrdinaryDiscriminantStrategy ods = new OrdinaryDiscriminantStrategy();
        RealDiscriminantStrategy rds = new RealDiscriminantStrategy();
        QuadraticEquationSolver oqes = new QuadraticEquationSolver(ods);
        QuadraticEquationSolver rqes = new QuadraticEquationSolver(rds);
        double a, b, c;
        boolean eq;
        Complex plus, minus;
        Pair<Complex, Complex> expected, result;

        a = 1;
        b = -1;
        c = -6;
        plus = new Complex(3, 0);
        minus = new Complex(-2, 0);
        expected = new Pair<>(plus, minus);
        result = oqes.solve(a, b, c);
        eq = expected.equals(result);
        assertTrue(eq);

        a = 1;
        b = -2;
        c = 5;
        plus = new Complex(1, 2);
        minus = new Complex(1, -2);
        expected = new Pair<>(plus, minus);
        result = oqes.solve(a, b, c);
        eq = expected.equals(result);
        assertTrue(eq);

        a = 1;
        b = -2;
        c = 5;
        plus = new Complex(NaN, NaN);
        minus = new Complex(NaN, NaN);
        expected = new Pair<>(plus, minus);
        result = rqes.solve(a, b, c);
        eq = expected.equals(result);
        assertTrue(eq);
    }
}