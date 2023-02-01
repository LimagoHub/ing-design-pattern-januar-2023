package de.composite.visitor;

import de.composite.Konto;
import de.composite.KontoGruppe;

public class PrintVisitor extends AbstractKontoVisitor{

    @Override
    public void visit(KontoGruppe kontoGruppe) {
        System.out.println(kontoGruppe);
    }

    @Override
    public void visit(Konto konto) {
        System.out.println(konto);
    }
}
