package com.etoitau.designpatterns.composite;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {


    @Test
    void sum() {
        TestSingleValue tsv = new TestSingleValue(1);
        TestManyValues tmv = new TestManyValues();
        tmv.add(0);
        tmv.add(2);

        ArrayList<ValueContainer> list = new ArrayList<>();
        list.add(tsv);
        list.add(tmv);
        MyList ml = new MyList(list);

        assertEquals(3, ml.sum());

    }

    class TestSingleValue implements ValueContainer
    {
        public int value;

        // please leave this constructor as-is
        public TestSingleValue(int value)
        {
            this.value = value;
        }

        @Override
        public Iterator<Integer> iterator() {
            return Collections.singleton(value).iterator();
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            action.accept(value);
        }

        @Override
        public Spliterator<Integer> spliterator() {
            return Collections.singleton(value).spliterator();
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    class TestManyValues extends ArrayList<Integer> implements ValueContainer
    {
        @Override
        public Integer getValue() {
            int sum = 0;
            for (Integer val : this) {
                sum += val;
            }
            return sum;
        }
    }
}