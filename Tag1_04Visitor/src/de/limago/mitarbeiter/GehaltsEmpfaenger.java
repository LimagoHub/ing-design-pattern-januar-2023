package de.limago.mitarbeiter;

import de.limago.mitarbeiter.visitors.MitarbeiterVisitor;

public class GehaltsEmpfaenger extends AbstractMitarbeiter{

    private double gehalt;

    public GehaltsEmpfaenger(String name, double gehalt) {
        super(name);
        this.gehalt = gehalt;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GehaltsEmpfaenger{");
        sb.append("gehalt=").append(gehalt);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void accept(MitarbeiterVisitor visitor) {
        visitor.visit(this);
    }

}
