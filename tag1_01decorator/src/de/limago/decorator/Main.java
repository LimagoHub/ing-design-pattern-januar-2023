package de.limago.decorator;

import de.CalcClient;
import de.math.*;

public class Main {
    public static void main(String[] args) {
        CalculatorFactory.setLogger(true);
        new CalcClient(CalculatorFactory.create()).go();
    }
}