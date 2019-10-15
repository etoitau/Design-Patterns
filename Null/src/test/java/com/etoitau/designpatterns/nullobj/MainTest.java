package com.etoitau.designpatterns.nullobj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void demoTest() {
        NullLog log = new NullLog();
        Account act = new Account(log);
        Exception e = null;
        try {
            for (int i = 0; i < 100; i++) {
                act.someOperation();
            }
        } catch (Exception e1) {
            e = e1;
        }
        assertNull(e);
    }
}