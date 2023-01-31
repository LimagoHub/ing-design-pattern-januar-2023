package de.command;

public class CommandHistory {

    public void addCommand(Command command) {
        if(command.isQuery()) return;
        // ...
    }

    public void undo() {
        System.out.println("can't undo");
    }

    public void redo() {
        System.out.println("can't undo");
    }
}
