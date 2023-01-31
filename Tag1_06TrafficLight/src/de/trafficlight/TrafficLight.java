package de.trafficlight;

public class TrafficLight {

    /* default */ final TrafficLightState red = new RedState(this);
    /* default */ final TrafficLightState green = new GreenState(this);
    /* default */ final TrafficLightState off = new OffState(this);
    /* default */ TrafficLightState current = off;

    public String getColor() {
        return current.getColor();
    }

    public void nextColor() {
        current.nextColor();
    }

    public void switchOn() {
        current.switchOn();
    }

    public void switchOff() {
        current.switchOff();
    }
}
