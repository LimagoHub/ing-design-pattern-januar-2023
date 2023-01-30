package de.limago.mitarbeiter.visitors;

import de.limago.mitarbeiter.AbstractMitarbeiter;
import de.limago.mitarbeiter.GehaltsEmpfaenger;
import de.limago.mitarbeiter.Lohnempfaenger;

public class PrintVisitor extends AbstractMitarbeiterVisitor{
    @Override
    public void visit(GehaltsEmpfaenger gehaltsEmpfaenger) {
        print(gehaltsEmpfaenger);
    }

    @Override
    public void visit(Lohnempfaenger lohnempfaenger) {
        print(lohnempfaenger);
    }

    private void print(AbstractMitarbeiter mitarbeiter) {
        System.out.println(mitarbeiter);
    }
}
