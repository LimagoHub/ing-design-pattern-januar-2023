package de.trafficlight;

public interface TrafficLightState {

    String getColor();
    void nextColor();

    void switchOn();

    void switchOff();
}
