package com.etoitau.designpatterns.memento;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void demoTest() {
        TokenMachine tm;
        Token a, b, c;
        Memento m;

        tm = new TokenMachine();
        a = new Token(1);
        b = new Token(2);
        c = new Token(3);
        tm.addToken(a);
        tm.addToken(b);
        m = tm.addToken(c); // take memento here
        tm.addToken(4);

        // check tm is working
        assertEquals(10, tm.sum());

        // stomp on the data
        b.value = 0;
        assertEquals(8, tm.sum());
        tm.tokens = new ArrayList<>();
        tm.tokens = null;

        tm.revert(m);
        // values restored
        assertEquals(6, tm.sum());
        // actual objects restored
        assertEquals(a, tm.tokens.get(0));
    }
}