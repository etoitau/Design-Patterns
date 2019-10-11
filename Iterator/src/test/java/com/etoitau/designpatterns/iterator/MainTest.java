package com.etoitau.designpatterns.iterator;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void mainTest() {
        Node<Integer> head;
        Iterator<Node<Integer>> it;
        StringBuilder sb;
        String expected;


        head = new Node<>(1, new Node<>(2), new Node<>(3));
        it = head.preOrder();
        sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().value);
        }
        expected = "123";
        assertEquals(expected, sb.toString());

        head = new Node<>(1);
        head.left = new Node<>(2);
        head.left.parent = head;
        it = head.preOrder();
        sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().value);
        }
        expected = "12";
        assertEquals(expected, sb.toString());

        head = new Node<>(1);
        head.right = new Node<>(3);
        head.right.parent = head;
        it = head.preOrder();
        sb = new StringBuilder();
        while (it.hasNext()) { sb.append(it.next().value); }
        expected = "13";
        assertEquals(expected, sb.toString());

        head = new Node<>(1);
        it = head.preOrder();
        sb = new StringBuilder();
        while (it.hasNext()) { sb.append(it.next().value); }
        expected = "1";
        assertEquals(expected, sb.toString());

        head = new Node<>(1,
                new Node<>(2,
                        new Node<>(4),
                        new Node<>(5)
                )
                , new Node<>(3));
        it = head.preOrder();
        sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().value);
        }
        expected = "12453";
        assertEquals(expected, sb.toString());

        head.right = null;
        head.left.right.left = new Node<>(6);
        head.left.right.left.parent = head.left.right;
        it = head.preOrder();
        sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().value);
        }
        expected = "12456";
        assertEquals(expected, sb.toString());

        Node<Character> cHead;
        Iterator<Node<Character>> cIt;

        cHead = new Node<>('a', new Node<>('b'), new Node<>('c'));
        cIt = cHead.preOrder();
        sb = new StringBuilder();
        while (cIt.hasNext()) {
            sb.append(cIt.next().value);
        }
        expected = "abc";
        assertEquals(expected, sb.toString());
    }
}