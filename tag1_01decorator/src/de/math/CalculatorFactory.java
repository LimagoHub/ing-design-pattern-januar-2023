package de.math;

import de.common.LoggerProxy;

public class CalculatorFactory {

    private static boolean logger = false;
    private static boolean secured = false;

    public static boolean isLogger() {
        return logger;
    }

    public static void setLogger(boolean logger) {
        CalculatorFactory.logger = logger;
    }

    public static boolean isSecured() {
        return secured;
    }

    public static void setSecured(boolean secured) {
        CalculatorFactory.secured = secured;
    }

    public static Calculator create() {

        Calculator calculator = new CalculatorImpl();
        //if(logger) calculator = new CalculatorLogger(calculator);
        if(logger) calculator = (Calculator) LoggerProxy.newInstance(calculator);
        if(secured) calculator = new CalculatorSecure(calculator);

        return calculator;

    }
}
