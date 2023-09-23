package week2.sortstrategy;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;


public class Controller extends JPanel implements Runnable {
    public final Random random = new Random();
    public final String programName = "Sort Strategy";
    public final String title = "Thuật toán sắp xếp";
    public final String xAxis = "Số lần sắp xếp";
    public final String yAxis = "Thời gian thực hiện";

    public final int maxWidth = 1200;
    public final int maxHeight = 700;
    public Dimension screen;

    public Thread threadMain;
    private int length = 0;
    private XYSeries bubble;
    private XYSeries selection;
    private XYSeries insertion;
    private XYSeries merge;
    private XYSeries quick;

    public Controller() {
        this.setName(programName);
        screen = new Dimension(maxWidth, maxHeight);
        this.setPreferredSize(screen);
        createData();
        startThread();

    }

    public void startThread() {
        threadMain = new Thread(this);
        threadMain.start();
    }


    @Override
    public void run() {
        while (threadMain != null) {
            if (length == 1_000) break;
            getData();
            repaint();
        }
        try {
            int delay = 1000 / 60;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void createData() {
        bubble = new XYSeries("Bubble Sort");
        insertion = new XYSeries("Insertion Sort");
        selection = new XYSeries("Selection Sort");
        quick = new XYSeries("Quick Sort");
        merge = new XYSeries("Merge Sort");
    }

    private int[] randomIntArray() {
        int[] data = new int[++length];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(1_000_000);
        }
        return data;
    }

    private void getData() {
        int[] data = randomIntArray();

        int[] copy = Arrays.copyOf(data, data.length);
        ISort bubbleSort = new BubbleSort();
        bubbleSort.sort(copy);
        bubble.add(length, bubbleSort.getTimes());

        copy = Arrays.copyOf(data, data.length);
        ISort insertionSort = new InsertionSort();
        insertionSort.sort(copy);
        bubble.add(length, insertionSort.getTimes());

        copy = Arrays.copyOf(data, data.length);
        ISort selectionSort = new SelectionSort();
        selectionSort.sort(copy);
        bubble.add(length, selectionSort.getTimes());

        copy = Arrays.copyOf(data, data.length);
        ISort mergeSort = new MergeSort();
        mergeSort.sort(copy);
        bubble.add(length, mergeSort.getTimes());

        copy = Arrays.copyOf(data, data.length);
        ISort quickSort = new QuickSort();
        quickSort.sort(copy);
        bubble.add(length, quickSort.getTimes());
    }

    @Override
    protected void printComponent(Graphics g) {
        super.printComponent(g);

        XYSeriesCollection data = new XYSeriesCollection();
        data.addSeries(bubble);
        data.addSeries(insertion);
        data.addSeries(selection);
        data.addSeries(merge);
        data.addSeries(quick);

        JFreeChart jFreeChart = ChartFactory.createXYLineChart(title, xAxis, yAxis, data, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(screen);
        add(chartPanel);
    }
}
