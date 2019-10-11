package com.etoitau.designpatterns.mediator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void demoTest() {
        Mediator m;
        Participant a, b, c;

        m = new Mediator();
        a = new Participant(m);
        b = new Participant(m);
        a.say(3);
        b.say(2);
        c = new Participant(m);
        a.say(1);
        m.leave(a);
        c.say(4);
        assertEquals(2, a.value);
        assertEquals(8, b.value);
        assertEquals(1, c.value);
    }
}