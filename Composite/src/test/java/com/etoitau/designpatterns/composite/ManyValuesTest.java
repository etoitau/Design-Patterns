package com.etoitau.designpatterns.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManyValuesTest {

    @Test
    void getValue() {
        ManyValues mv = new ManyValues();
        mv.add(0);
        mv.add(12);
        mv.add(-20);
        assertEquals(-8, mv.getValue());
    }
}