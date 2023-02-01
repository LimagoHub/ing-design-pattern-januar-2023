package de.generator.impl;

import de.generator.Generator;

import java.util.Random;

public class RandomNumberGenerator implements Generator<Integer> {

    private Random random = new Random();
    @Override
    public Integer next() {
        return random.nextInt();
    }
}
