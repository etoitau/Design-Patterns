package com.etoitau.designpatterns.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {

    @Test
    void dragon() {
        Dragon dragon = new Dragon();
        dragon.setAge(0);
        assertEquals("too young", dragon.crawl());
        assertEquals("flying", dragon.fly());
        dragon.setAge(100);
        assertEquals("crawling", dragon.crawl());
        assertEquals("too old", dragon.fly());
    }
}