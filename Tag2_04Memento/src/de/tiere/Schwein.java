package de.tiere;

public class Schwein {

    private String name;
    private int gewicht;





    public Schwein() {
        this("Nobody");
    }

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
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schwein{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gewicht=").append(gewicht);
        sb.append('}');
        return sb.toString();
    }

    public void fuettern() {
        setGewicht(getGewicht() +  1);
    }

    public SchweineMemento getMemento() {
        return new MySchweineMemento(name, gewicht);
    }

    public void setMemento(SchweineMemento memento) {
        MySchweineMemento mySchweineMemento = (MySchweineMemento) memento;
        setName(mySchweineMemento.getName());
        setGewicht(mySchweineMemento.getGewicht());
    }

    static class MySchweineMemento implements SchweineMemento {
        private final String name;
        private final int gewicht;

        public MySchweineMemento(final String name, final int gewicht) {
            this.name = name;
            this.gewicht = gewicht;
        }

        public String getName() {
            return name;
        }

        public int getGewicht() {
            return gewicht;
        }
    }
}
