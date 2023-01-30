package de.limago.mitarbeiter.visitors;

import de.limago.mitarbeiter.GehaltsEmpfaenger;
import de.limago.mitarbeiter.Lohnempfaenger;

public abstract class AbstractMitarbeiterVisitor implements MitarbeiterVisitor{
    @Override
    public void visit(GehaltsEmpfaenger gehaltsEmpfaenger) {
        // NOP
    }

    @Override
    public void visit(Lohnempfaenger lohnempfaenger) {
        // NOP
    }

    @Override
    public void init() {

    }

    @Override
    public void dispose() {

    }
}
