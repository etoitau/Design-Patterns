package com.etoitau.designpatterns.observable;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void demoTest() throws IOException {
        Game game = new Game();
        Rat r1 = new Rat(game);
        assertEquals(1, r1.attack);
        Rat r2 = new Rat(game);
        assertEquals(2, r1.attack);
        r1.close();
        assertEquals(1, r2.attack);

    }
}