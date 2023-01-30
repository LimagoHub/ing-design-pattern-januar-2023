package state;

public class Frontend {
    /* default */ final State stateA = new StateA(this);
    /* default */ final State stateB = new StateB(this);
    /* default */ State current = stateA;

    public void print() {
        current.print();
    }

    public void changeToA() {
        current.changeToA();
    }

    public void changeToB() {
        current.changeToB();
    }
}
