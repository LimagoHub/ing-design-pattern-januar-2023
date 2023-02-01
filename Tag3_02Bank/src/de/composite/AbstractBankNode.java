package de.composite;

import de.composite.visitor.KontoVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBankNode {

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


    public void iterate(KontoVisitor visitor) {
        visitor.init();
        iterator().forEachRemaining(k->k.accept(visitor));
        visitor.dispose();
    }

    public void print() {
       iterator().forEachRemaining(System.out::println);
    }

    public Iterator<AbstractBankNode> iterator() {
        List<AbstractBankNode> list = new ArrayList<>();
        iteratorHelper(list);
        return list.iterator(); // sich selbst und alle Kinder und Kindeskinder self or descant
    }

    private void iteratorHelper(List<AbstractBankNode> list ) {
        list.add(this);
        for (var child : getChildren()) {
            child.iteratorHelper(list);
        }
    }
    public abstract void accept(KontoVisitor visitor) ;
}
