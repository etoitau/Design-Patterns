package com.etoitau.designpatterns.composite;

import java.util.*;
import java.util.function.Consumer;

public class Exercise {
    public static void main(String[] args) {

    }
}

interface ValueContainer extends Iterable<Integer> {
    public Integer getValue();
}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
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

class ManyValues extends ArrayList<Integer> implements ValueContainer
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


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        int sum = 0;
        for (ValueContainer vc: this) {
            sum += vc.getValue();
        }
        return sum;
    }
}
