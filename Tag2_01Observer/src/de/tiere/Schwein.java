package de.tiere;

import java.util.ArrayList;
import java.util.List;

public class Schwein {

    private List<PigToFatListerner> pigToFatListeners = new ArrayList<>();

    public void addPigToFatListener(PigToFatListerner listerner) {
        pigToFatListeners.add(listerner);
    }

    public void removePigToFatListener(PigToFatListerner listerner) {
        pigToFatListeners.remove(listerner);
    }

    private void firePigToFatEvent(){
        for(var listner: pigToFatListeners){
            listner.pigToFat(this);
        }
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
        this.name = name;
    }

    public int getGewicht() {
        return gewicht;
    }

    private void setGewicht(int gewicht) {
        this.gewicht = gewicht;
        if(gewicht > 20) firePigToFatEvent();
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
