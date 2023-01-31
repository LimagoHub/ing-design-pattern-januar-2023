package de.tiere;

import de.events.PropertyChangedEvent;
import de.events.PropertyChangedListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Schwein {

    private List<PigToFatListerner> pigToFatListeners = new ArrayList<>();

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private void firePigToFatEvent(){
        for(var listner: pigToFatListeners){
            listner.pigToFat(this);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void firePropertyChange(PropertyChangeEvent event) {
        propertyChangeSupport.firePropertyChange(event);
    }

    private String name;
    private int gewicht;

    public Schwein(String name) {
        this.name = name;
        this.gewicht = 10;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(this.name.equals(name)) return;
        firePropertyChange( new PropertyChangeEvent(this,"name", this.name, this.name = name));
     }

    public int getGewicht() {
        return gewicht;
    }

    private void setGewicht(int gewicht) {
        if(this.gewicht == gewicht) return;
        firePropertyChange( new PropertyChangeEvent(this,"gewicht", this.gewicht, this.gewicht = gewicht));
        if(this.gewicht > 20) firePigToFatEvent();
    }

    public void fuettern() {
        setGewicht(getGewicht() + 1);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schwein{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gewicht=").append(gewicht);
        sb.append('}');
        return sb.toString();
    }
}
