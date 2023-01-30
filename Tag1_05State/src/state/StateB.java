package state;

public class StateB extends AbstractState{

    public StateB(Frontend frontend) {
        super(frontend);
    }

    @Override
    public void print() {
        System.out.println("Hier druckt B");
    }

    @Override
    public void changeToA() {
        getFrontend().current = getFrontend().stateA;
    }
}
