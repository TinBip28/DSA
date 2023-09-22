package week1.exercise6.p_2_32;

import week1.exercise6.p_2_32.ui.GamePanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame windown = new JFrame();
        windown.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windown.setResizable(false);

        GamePanel game = new GamePanel();
        windown.add(game);
        windown.pack();

        windown.setLocationRelativeTo(null);
        windown.setVisible(true);
    }
}
