package de.trafficlight;

public class OffState extends AbstractTrafficLightState{
    public OffState(TrafficLight trafficLight) {
        super(trafficLight);
    }

    @Override
    public void switchOn() {
        getTrafficLight().current = getTrafficLight().red;
    }
}
