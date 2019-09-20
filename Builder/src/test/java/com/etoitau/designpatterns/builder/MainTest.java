package com.etoitau.designpatterns.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void main() {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        String expected = "public class Person\n{\n  public String name;\n  public int age;\n}";
        assertEquals(expected, cb.toString());
    }
}