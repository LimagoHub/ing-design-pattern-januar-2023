package de.composite;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AbstractBankNode {

    private AbstractBankNode parent = null;
    private String label;

    public AbstractBankNode(String label) {
        this.label = label;
    }

    public AbstractBankNode getParent() {
        return parent;
    }

    public void setParent(AbstractBankNode parent) {
        this.parent = parent;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName() +":");
        sb.append("label='").append(label).append('\'');

        return sb.toString();
    }


    public List<AbstractBankNode> getChildren() {
        return Collections.emptyList();
    }

//    public void print() {
//        System.out.println(this);
//        getChildren().forEach(AbstractBankNode::print);
//    }

    public void print() {
       iterator().forEachRemaining(System.out::println);
    }

    public Iterator<AbstractBankNode> iterator() {
        return null; // sich selbst und alle Kinder und Kindeskinder self or descant
    }
}
