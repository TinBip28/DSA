package week6.sortstrategy_ex3;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        JFrame windown = new JFrame();
        windown.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windown.setResizable(false);

        Controller game = new Controller();
        windown.add(game);
        windown.pack();

        windown.setLocationRelativeTo(null);
        windown.setVisible(true);
    }
}
