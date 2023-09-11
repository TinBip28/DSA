package exercise6.p_2_32;

import exercise6.p_2_32.entity.EAnimal;
import exercise6.p_2_32.entity.Forest;
import exercise6.p_2_32.entity.Tiger;
import exercise6.p_2_32.ui.GamePanel;

import javax.swing.*;

public class Main {
//    public static void main(String[] args) {
//        Forest forest = Forest.getInstance(16, 12);
//        forest.add(EAnimal.TIGER, 5)
//                .add(EAnimal.FISH, 6);
//        forest.add(new Tiger("0203123",true,1000),15,11);
//        System.out.println(forest);
//        forest.go();
//        System.out.println(forest);
//
//    }
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
