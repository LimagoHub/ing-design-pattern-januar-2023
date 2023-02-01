package de.processor;

public class CharacterCounter implements CharacterHandler{

    int counter = 0;

    @Override
    public void init() {
        counter = 0;
    }

    @Override
    public void process(char c) {
        counter ++;
    }

    @Override
    public void dispose() {
        System.out.println(counter);
    }
}
