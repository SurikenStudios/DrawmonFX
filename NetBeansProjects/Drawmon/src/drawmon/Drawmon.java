package drawmon;

import java.util.Scanner;
import javax.swing.JFrame;

public class Drawmon {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Dibujo libre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new MyPanel());
        frame.setVisible(true);
    }
}
