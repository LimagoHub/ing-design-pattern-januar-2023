package de.tiere;

import de.events.PropertyChangedEvent;
import de.events.PropertyChangedListener;

import java.util.ArrayList;
import java.util.List;

public class Schwein {

    private List<PigToFatListerner> pigToFatListeners = new ArrayList<>();
    private List<PropertyChangedListener> propertyChangedListeners = new ArrayList<>();

    public void addPigToFatListener(PigToFatListerner listerner) {
        pigToFatListeners.add(listerner);
    }

    public void removePigToFatListener(PigToFatListerner listerner) {
        pigToFatListeners.remove(listerner);
    }

    public void addPropertyChangedListener(PropertyChangedListener listerner) {
        propertyChangedListeners.add(listerner);
    }

    public void removePropertyChangedListener(PropertyChangedListener listerner) {
        propertyChangedListeners.remove(listerner);
    }


    private void firePigToFatEvent(){
        for(var listner: pigToFatListeners){
            listner.pigToFat(this);
        }
    }

    private void firePropertyChanged(final PropertyChangedEvent event) {
        propertyChangedListeners.forEach(listener->listener.propertyChanged(event));
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
        firePropertyChanged( new PropertyChangedEvent(this,"name", this.name, this.name = name));
     }

    public int getGewicht() {
        return gewicht;
    }

    private void setGewicht(int gewicht) {
        if(this.gewicht == gewicht) return;
        firePropertyChanged( new PropertyChangedEvent(this,"gewicht", this.gewicht, this.gewicht = gewicht));
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
