package de.limago.mitarbeiter;

import de.limago.mitarbeiter.visitors.MitarbeiterVisitor;

public class Lohnempfaenger extends AbstractMitarbeiter{

    private double stundenlohn;
    private double arbeitszeit;

    public Lohnempfaenger(String name) {
        super(name);
    }

    @Override
    public void accept(MitarbeiterVisitor visitor) {
        visitor.visit(this);
    }

    public Lohnempfaenger(String name, double stundenlohn, double arbeitszeit) {
        super(name);
        this.stundenlohn = stundenlohn;
        this.arbeitszeit = arbeitszeit;
    }

    public double getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(double stundenlohn) {
        this.stundenlohn = stundenlohn;
    }

    public double getArbeitszeit() {
        return arbeitszeit;
    }

    public void setArbeitszeit(double arbeitszeit) {
        this.arbeitszeit = arbeitszeit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lohnempfaenger{");
        sb.append("stundenlohn=").append(stundenlohn);
        sb.append(", arbeitszeit=").append(arbeitszeit);
        sb.append('}');
        return sb.toString();
    }
}
