package client;

import state.Frontend;

public class Client {

    public void go() {
        Frontend frontend = new Frontend();
        frontend.print();

        frontend.changeToB();

        frontend.print();

        frontend.changeToB();
    }
}
