package de.generator;

public interface GeneratorFactory<T> {

    Generator<T> create();
}
