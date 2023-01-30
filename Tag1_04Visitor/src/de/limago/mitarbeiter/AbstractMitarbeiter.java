package de.limago.mitarbeiter;

import de.limago.mitarbeiter.visitors.MitarbeiterVisitor;

public abstract class AbstractMitarbeiter {

    private String name;

    public AbstractMitarbeiter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void accept(MitarbeiterVisitor visitor);
}
