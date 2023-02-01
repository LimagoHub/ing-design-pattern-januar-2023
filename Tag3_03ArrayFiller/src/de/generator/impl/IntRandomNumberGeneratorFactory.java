package de.generator.impl;

import de.generator.Generator;
import de.generator.IntGenerator;
import de.generator.IntGerneratorFactory;

public class IntRandomNumberGeneratorFactory implements IntGerneratorFactory {

    @Override
    public IntGenerator create() {
        return new IntRandomNumberGenerator();
    }
}
