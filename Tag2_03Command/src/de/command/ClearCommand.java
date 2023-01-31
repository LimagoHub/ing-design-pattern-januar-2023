package de.command;

import de.math.Calculator;

public class ClearCommand extends AbstractCommand{

    private double oldValue;

    @Override
    public void undo() {
        Calculator.getInstance().setMemory(oldValue);
    }

    @Override
    public boolean isQuery() {
        return false;
    }

    @Override
    public void execute() {
        oldValue = Calculator.getInstance().getMemory();
        Calculator.getInstance().clear();
    }
}
