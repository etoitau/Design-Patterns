package com.etoitau.designpatterns.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Spliterator;

import static org.junit.jupiter.api.Assertions.*;


class SingleValueTest {

    int testVal;
    SingleValue sv;

    @BeforeEach
    void init() {
        testVal = 5;
        sv = new SingleValue(testVal);
    }

    @Test
    void getValue() {
        assertEquals(testVal, sv.getValue());
    }


    @Test
    void iterator() {
        int sum = 0;
        for (Integer val: sv)
            sum += val;
        assertEquals(testVal, sum);
    }

    @Test
    void forEach() {
        sv.forEach(v -> assertEquals(testVal, v));
    }

    @Test
    void spliterator() {
        Spliterator<Integer> s = sv.spliterator();
        while (s.tryAdvance(v -> assertEquals(testVal, v))){}
    }
}