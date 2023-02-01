package de.composite.visitor;

import de.composite.Konto;
import de.composite.KontoGruppe;

public interface KontoVisitor {

    void init();
    void dispose();
    void visit(KontoGruppe kontoGruppe);
    void visit(Konto konto);
}
