package com.etoitau.designpatterns.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponsiblePersonTest {
    @Test
    void drink() {
        Person rp;
        rp = new ResponsiblePerson(new Person(17));
        assertEquals("too young", rp.drink());

        rp = new ResponsiblePerson(new Person(18));
        assertEquals("drinking", rp.drink());
    }

    @Test
    void drive() {
        Person rp;
        rp = new ResponsiblePerson(new Person(15));
        assertEquals("too young", rp.drive());

        rp = new ResponsiblePerson(new Person(16));
        assertEquals("driving", rp.drive());
    }

    @Test
    void drinkAndDrive() {
        Person rp;
        rp = new ResponsiblePerson(new Person(21));
        assertEquals("dead", rp.drinkAndDrive());
    }
}