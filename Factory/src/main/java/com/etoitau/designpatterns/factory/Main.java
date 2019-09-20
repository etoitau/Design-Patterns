package com.etoitau.designpatterns.factory;

public class Main {
    public static void main(String[] args) {
        PersonFactory factory = new PersonFactory();
        Person one = factory.createPerson("one");
        Person two = factory.createPerson("two");
        System.out.println(one);
        System.out.println(two);
    }
}
