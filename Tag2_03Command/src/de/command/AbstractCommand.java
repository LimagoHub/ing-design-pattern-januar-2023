package de.command;

public abstract class AbstractCommand implements Command{
    @Override
    public void parse(String[] tokens) {
        // NOP
    }



    @Override
    public void undo() {
        throw new UnsupportedOperationException("Upps");
    }

    @Override
    public boolean isQuery() {
        return true;
    }
}
