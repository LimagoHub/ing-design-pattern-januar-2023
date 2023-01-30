package state;

public class StateA extends AbstractState{
    public StateA(Frontend frontend) {
        super(frontend);
    }

    @Override
    public void print() {
        System.out.println("Hier druckt A");
    }

    @Override
    public void changeToB() {
        getFrontend().current = getFrontend().stateB;
    }
}
