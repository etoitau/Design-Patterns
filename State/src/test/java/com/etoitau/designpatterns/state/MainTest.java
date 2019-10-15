package com.etoitau.designpatterns.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void lockTest() {
        CombinationLock cl = new CombinationLock(new int[]{1, 2, 3, 4});
        assertEquals("LOCKED", cl.status);
        cl.enterDigit(1);
        assertEquals("1", cl.status);
        cl.enterDigit(2);
        assertEquals("12", cl.status);
        cl.enterDigit(3);
        assertEquals("123", cl.status);
        cl.enterDigit(4);
        assertEquals("OPEN", cl.status);

        cl = new CombinationLock(new int[]{5});
        assertEquals("LOCKED", cl.status);
        cl.enterDigit(4);
        assertEquals("ERROR", cl.status);
        cl.enterDigit(5);
        assertEquals("ERROR", cl.status);

        cl = new CombinationLock(new int[]{1, 2, 3, 4});
        assertEquals("LOCKED", cl.status);
        cl.enterDigit(2);
        assertEquals("2", cl.status);
        cl.enterDigit(2);
        assertEquals("22", cl.status);
        cl.enterDigit(2);
        assertEquals("222", cl.status);
        cl.enterDigit(2);
        assertEquals("ERROR", cl.status);
        cl.enterDigit(1);
        cl.enterDigit(2);
        cl.enterDigit(3);
        cl.enterDigit(4);
        assertEquals("ERROR", cl.status);
    }
}