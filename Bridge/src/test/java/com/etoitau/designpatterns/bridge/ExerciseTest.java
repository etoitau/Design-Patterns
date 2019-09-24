package com.etoitau.designpatterns.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class ExerciseTest {

    @Test
    void main() {
        String tr = new Triangle(new RasterRenderer()).toString();
        assertEquals("Drawing Triangle as pixels", tr);

        String sv = new Square(new VectorRenderer()).toString();
        assertEquals("Drawing Square as lines", sv);
    }
}