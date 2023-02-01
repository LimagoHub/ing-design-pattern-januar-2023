package de.composite.visitor;

import de.composite.Konto;
import de.composite.KontoGruppe;

public abstract class AbstractKontoVisitor implements KontoVisitor{


    @Override
    public void init() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void visit(KontoGruppe kontoGruppe) {

    }

    @Override
    public void visit(Konto konto) {

    }
}
