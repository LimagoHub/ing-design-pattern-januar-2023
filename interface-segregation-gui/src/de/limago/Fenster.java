package de.limago;

import java.awt.*;
import java.awt.event.*;

public class Fenster extends Frame{


    public Fenster()  {

        setSize(300, 300);
        addWindowListener(new MyWindowListner());
        Button button = new Button("Drück mich");
        button.addActionListener(new MyActionListener());
        add(button);
    }


    public static void main(String[] args) {
	    new Fenster().setVisible(true);
    }

    private void ausgeben() {
        System.out.println("Button wurde gedrückt");
    }

    private void beenden() {
        dispose();
    }

    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           ausgeben();
        }
    }

    class MyWindowListner extends  WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            beenden();
        }
    }
}
