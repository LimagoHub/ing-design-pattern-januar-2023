package de.limago.application;

import de.trafficlight.TrafficLight;

public class Main {
    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();

        for (int i = 0; i < 5; i++, trafficLight.nextColor()) {
            System.out.println(trafficLight.getColor());
        }
    }
}