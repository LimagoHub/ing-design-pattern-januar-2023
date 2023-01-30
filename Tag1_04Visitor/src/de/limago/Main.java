package de.limago;

import de.limago.mitarbeiter.GehaltsEmpfaenger;
import de.limago.mitarbeiter.Lohnempfaenger;
import de.limago.mitarbeiter.visitors.PrintVisitor;
import de.limago.mitarbeiter.visitors.ResetArbeitszeitVisitor;

public class Main {
    public static void main(String[] args) {
        Firma firma = new Firma();
        firma.addMitarbeiter(new GehaltsEmpfaenger("Hinz", 1000));
        firma.addMitarbeiter(new GehaltsEmpfaenger("Kunz", 2000));
        firma.addMitarbeiter(new Lohnempfaenger("Meier", 20, 20));
        firma.addMitarbeiter(new Lohnempfaenger("Schmitt", 20, 40));
        firma.addMitarbeiter(new GehaltsEmpfaenger("Schulz", 3000));

        //firma.print();
        firma.iterate(new PrintVisitor());
        firma.iterate(new ResetArbeitszeitVisitor());
        firma.iterate(new PrintVisitor());
    }
}