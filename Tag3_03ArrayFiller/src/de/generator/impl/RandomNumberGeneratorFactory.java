package de.generator.impl;

import de.generator.Generator;
import de.generator.GeneratorFactory;

public class RandomNumberGeneratorFactory implements GeneratorFactory<Integer> {
    @Override
    public Generator<Integer> create() {
        return new RandomNumberGenerator();
    }
}
