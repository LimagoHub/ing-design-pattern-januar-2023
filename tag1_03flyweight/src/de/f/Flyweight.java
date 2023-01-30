package de.f;

import java.util.ArrayList;
import java.util.List;

public class Flyweight {

    private final List<Flyweight> characters = new ArrayList<>();

    private final char c;
    private final boolean bold;

    private Flyweight(char c, boolean bold) {
        this.c = c;
        this.bold = bold;
        characters.add(this);
    }

    public Flyweight getInstance(char c, boolean bold) {
        for (var flyWeight: characters ) {
            if(flyWeight.c == c && flyWeight.bold == bold) return flyWeight;
        }
        return new Flyweight(c,bold);
    }

    public char getC() {
        return c;
    }

    public boolean isBold() {
        return bold;
    }
}
