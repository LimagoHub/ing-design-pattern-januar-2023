package app;

import de.tiere.Schwein;
import de.tiere.SchweineMemento;

public class Main {
    public static void main(String[] args) {

        Schwein piggy = new Schwein("Miss Piggy");

        System.out.println(piggy);

        SchweineMemento memento = piggy.getMemento();

        piggy.fuettern();

        System.out.println(piggy);

        piggy.setMemento(memento);

        System.out.println(piggy);

    }
}