package de.trafficlight;

public class TrafficLight {

    /* default */ final TrafficLightState red = new RedState(this);
    /* default */ final TrafficLightState green = new GreenState(this);
    /* default */ TrafficLightState current = red;

    public String getColor() {
        return current.getColor();
    }

    public void nextColor() {
        current.nextColor();
    }
}
