package state;

public class AbstractState implements State{

    private final Frontend frontend;

    public AbstractState(Frontend frontend) {
        this.frontend = frontend;
    }

    public Frontend getFrontend() {
        return frontend;
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Diese Methode macht in diesem Zustand keinen Sinn!");
    }

    @Override
    public void changeToA() {
        throw new UnsupportedOperationException("Diese Methode macht in diesem Zustand keinen Sinn!");
    }

    @Override
    public void changeToB() {
        throw new UnsupportedOperationException("Diese Methode macht in diesem Zustand keinen Sinn!");
    }
}
