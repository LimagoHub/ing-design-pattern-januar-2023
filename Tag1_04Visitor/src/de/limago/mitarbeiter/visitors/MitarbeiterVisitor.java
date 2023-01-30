package de.limago.mitarbeiter.visitors;

import de.limago.mitarbeiter.GehaltsEmpfaenger;
import de.limago.mitarbeiter.Lohnempfaenger;

public interface MitarbeiterVisitor {

    void visit(GehaltsEmpfaenger gehaltsEmpfaenger);
    void visit(Lohnempfaenger lohnempfaenger);
}
