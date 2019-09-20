package com.etoitau.designpatterns.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void deepCopy() {
        int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7;
        Point p1 = new Point(a, b);
        Point p2 = new Point(c, d);
        Line l1 = new Line(p1, p2);
        Line l2 = l1.deepCopy();
        l2.start.x = e;
        l2.start.y = f;
        l2.end.x = g;
        l2.end.y = h;
        assertEquals(a, l1.start.x);
        assertEquals(b, l1.start.y);
        assertEquals(c, l1.end.x);
        assertEquals(d, l1.end.y);
        assertEquals(e, l2.start.x);
        assertEquals(f, l2.start.y);
        assertEquals(g, l2.end.x);
        assertEquals(h, l2.end.y);
    }
}