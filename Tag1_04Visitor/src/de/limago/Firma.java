package de.limago;

import de.limago.mitarbeiter.AbstractMitarbeiter;
import de.limago.mitarbeiter.visitors.MitarbeiterVisitor;

import java.util.ArrayList;
import java.util.List;

public class Firma {

    private List<AbstractMitarbeiter> mitarbeiters = new ArrayList<>();

    public void addMitarbeiter(AbstractMitarbeiter mitarbeiter) {
        mitarbeiters.add(mitarbeiter);
    }
    public void removeMitarbeiter(AbstractMitarbeiter mitarbeiter) {
        mitarbeiters.remove(mitarbeiter);
    }

    public void print() {
       mitarbeiters.forEach(System.out::println);
    }

    public void iterate(MitarbeiterVisitor visitor) {
        visitor.init();
        for (AbstractMitarbeiter mitarbeiter: mitarbeiters) {
            mitarbeiter.accept(visitor);
        }
        visitor.dispose();
    }
}
