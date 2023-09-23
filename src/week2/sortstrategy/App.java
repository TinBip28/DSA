package week2.sortstrategy;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);

        Controller comparisonChart = new Controller();
        window.add(comparisonChart);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
