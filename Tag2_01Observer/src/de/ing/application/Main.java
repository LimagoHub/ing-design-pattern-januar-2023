package de.ing.application;

import de.events.PropertyChangedEvent;
import de.events.PropertyChangedListener;
import de.tiere.PigToFatListerner;
import de.tiere.Schwein;

public class Main {

    private Metzger metzger = new Metzger();
    private Spediteur spediteur = new Spediteur();

    public static void main(String[] args) {

       new Main().run();
    }

    private void run() {
        Schwein schwein = new Schwein("Miss Piggy");
        schwein.addPigToFatListener(new SchweineMetzgerAdapter());
        schwein.addPigToFatListener(s->spediteur.fahren(s));
        schwein.addPigToFatListener(spediteur::fahren);

        schwein.addPropertyChangedListener(new PropertyChangedListener() {
            @Override
            public void propertyChanged(PropertyChangedEvent event) {
                System.out.println(event);
            }
        });
        for (int i = 0; i < 11; i++) {
            schwein.fuettern();
        }

    }

    class SchweineMetzgerAdapter implements PigToFatListerner {

        @Override
        public void pigToFat(Schwein sender) {
            metzger.schlachten(sender);
        }
    }
}

class Metzger {


    public void schlachten(Object tier) {
        System.out.println("Messer wetz!");
    }
}

class Spediteur  {


    public void fahren(Object ware) {
        System.out.println("Wir fahren auf der Autobahn");
    }
}