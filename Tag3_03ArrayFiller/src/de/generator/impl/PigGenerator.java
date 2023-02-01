package de.generator.impl;

import de.generator.Generator;
import de.tiere.Schwein;

public class PigGenerator implements Generator<Schwein> {
    @Override
    public Schwein next() {
        return new Schwein();
    }
}
