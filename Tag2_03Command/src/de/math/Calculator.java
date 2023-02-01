package de.math;

public class Calculator {

    private static final Calculator instance = new Calculator();
    private double memory;
    public static Calculator getInstance() {
        return instance;
    }

    private double getMemory() {
        return memory;
    }

    private void setMemory(double memory) {
        this.memory = memory;
    }

    private Calculator() {
        this.memory = 0.0;
    }

    public void add(double value) {
        memory += value;
    }
    public void sub(double value) {
        memory -= value;
    }
    public void mult(double value) {
        memory *= value;
    }
    public void div(double value) {
        memory /= value;
    }

    public void clear() {
        memory = 0;
    }

    public void print() {
        System.out.println(memory);
    }



    public CalculatorMemento getMemento() {
        return new MyCalculatorMemento(getMemory());
    }

    public void setMemento(CalculatorMemento memento) {
        setMemory( ((MyCalculatorMemento) memento).getMemory()
        );
    }

    static class MyCalculatorMemento implements CalculatorMemento {
        private final double memory;

        public MyCalculatorMemento(double memory) {
            this.memory = memory;
        }

        public double getMemory() {
            return memory;
        }
    }
}
