package week2.sortstrategy;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

import javax.swing.*;
import java.util.Arrays;

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
