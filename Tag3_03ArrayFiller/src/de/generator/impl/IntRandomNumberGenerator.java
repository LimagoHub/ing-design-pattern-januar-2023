package de.generator.impl;

import de.generator.IntGenerator;

import java.util.Random;

public class IntRandomNumberGenerator implements IntGenerator {

    private Random random = new Random();
    @Override
    public int next() {
        return random.nextInt();
    }
}
