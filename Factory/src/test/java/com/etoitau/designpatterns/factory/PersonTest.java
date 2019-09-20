package com.etoitau.designpatterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void factoryTest() {
        PersonFactory factory = new PersonFactory();
        Person one = factory.createPerson("one");
        Person two = factory.createPerson("two");
        assertEquals(0, one.id);
        assertEquals("one", one.name);
        assertEquals(1, two.id);
        assertEquals("two", two.name);
    }

}