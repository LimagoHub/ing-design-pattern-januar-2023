package de.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KontoGruppe extends AbstractBankNode {

    private List<AbstractBankNode> children = new ArrayList<>();

    public KontoGruppe(String label) {
        super(label);
    }

    @Override
    public List<AbstractBankNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void append(AbstractBankNode child) {
        child.setParent(this);
        children.add(child);
    }

    public void remove(AbstractBankNode child) {
        child.setParent(null);
        children.remove(child);
    }


}
