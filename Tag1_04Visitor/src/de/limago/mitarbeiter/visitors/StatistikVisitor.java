package de.limago.mitarbeiter.visitors;

import de.limago.mitarbeiter.GehaltsEmpfaenger;
import de.limago.mitarbeiter.Lohnempfaenger;

public class StatistikVisitor extends AbstractMitarbeiterVisitor{

    private int gCounter=0;
    private int lCounter=0;

    @Override
    public void init() {
        gCounter = 0;
        lCounter = 0;
    }

    @Override
    public void dispose() {
        System.out.println(toString());
    }

    public int getgCounter() {
        return gCounter;
    }

    public int getlCounter() {
        return lCounter;
    }

    public int getGesamt() {
        return lCounter + gCounter;
    }

    @Override
    public void visit(GehaltsEmpfaenger gehaltsEmpfaenger) {
        gCounter ++;
    }
    @Override
    public void visit(Lohnempfaenger lohnempfaenger) {
        lCounter ++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatistikVisitor{");
        sb.append("gCounter=").append(gCounter);
        sb.append(", lCounter=").append(lCounter);
        sb.append('}');
        return sb.toString();
    }
}
