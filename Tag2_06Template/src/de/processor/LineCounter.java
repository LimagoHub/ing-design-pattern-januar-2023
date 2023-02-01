package de.processor;

public class LineCounter implements  CharacterHandler{

    int counter = 0;

    @Override
    public void init() {
        counter = 0;
    }

    @Override
    public void process(char c) {
        if(c == '\n')
            counter ++;
    }

    @Override
    public void dispose() {
        System.out.println(counter);
    }
}
