package singleton;

public class Singleton {

    private final Singleton instance = new Singleton();

    public synchronized  Singleton getInstance() {
        
        return instance;
    }

   private Singleton() {

    }

    public void doIt() {

    }
}
