package de.trafficlight;

public abstract class AbstractTrafficLightState implements TrafficLightState{

    private final TrafficLight trafficLight;

    public AbstractTrafficLightState(final TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public String getColor() {
        throw new UnsupportedOperationException("Upps");
    }

    @Override
    public void nextColor() {
        throw new UnsupportedOperationException("Upps");
    }

    @Override
    public void switchOn() {
        throw new UnsupportedOperationException("Upps");
    }

    @Override
    public void switchOff() {
        throw new UnsupportedOperationException("Upps");
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }
}
