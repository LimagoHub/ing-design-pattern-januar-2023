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
        for (AbstractMitarbeiter mitarbeiter: mitarbeiters) {
            System.out.println(mitarbeiter);
        }
    }

    public void iterate(MitarbeiterVisitor visitor) {
        for (AbstractMitarbeiter mitarbeiter: mitarbeiters) {
            mitarbeiter.accept(visitor);
        }
    }
}
