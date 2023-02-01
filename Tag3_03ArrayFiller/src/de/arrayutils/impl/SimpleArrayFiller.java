package de.arrayutils.impl;

import de.arrayutils.ArrayFiller;
import de.generator.Generator;

public class SimpleArrayFiller<T> implements ArrayFiller<T> {

    private final Generator<T> generator;

    public SimpleArrayFiller(Generator<T> generator) {
        this.generator = generator;
    }

    @Override
    public void fill(T[] arryToFill) {
        for(int i = 0; i < arryToFill.length; i ++)
            arryToFill[i] = generator.next();
    }
}
