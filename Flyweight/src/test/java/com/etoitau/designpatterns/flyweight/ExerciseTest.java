package com.etoitau.designpatterns.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class ExerciseTest {

    @Test
    void main() {
        Sentence sentence;

        sentence = new Sentence("hellow world");
        sentence.getWord(1).capitalize = true;
        assertEquals("hellow WORLD", sentence.toString());

        sentence = new Sentence("hello");
        sentence.getWord(0).capitalize = true;
        assertEquals("HELLO", sentence.toString());

        sentence = new Sentence("a test.");
        sentence.getWord(0).capitalize = true;
        sentence.getWord(1).capitalize = true;
        sentence.getWord(0).capitalize = false;
        assertEquals("a TEST.", sentence.toString());
    }
}