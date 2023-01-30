package de.limago.mitarbeiter.visitors;

import de.limago.mitarbeiter.Lohnempfaenger;

public class ResetArbeitszeitVisitor extends AbstractMitarbeiterVisitor{

    @Override
    public void visit(Lohnempfaenger lohnempfaenger) {
        lohnempfaenger.setArbeitszeit(0);
    }
}
