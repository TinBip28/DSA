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
    public final String nameProgram = "Sorting";
    public final String nameChart = "So sánh các thuật toán sắp xếp";
    public final String xAxis = "Số phần tử sắp xếp";
    private final String yAxis = "Thời gian sắp xếp";

    public final int maxWidth = 1000;
    public final int maxHeight = 720;
    public Thread threadMain;

    public double FPS = 60;

    private XYSeries bubble;
    private XYSeries bubble2;
    private XYSeries insertion;
    private XYSeries selection;
    private XYSeries merge;
    private XYSeries quick;

    private int number = 1;

    public Controller() {
        this.setName(nameProgram);
        this.setPreferredSize(new Dimension(maxWidth + 10, maxHeight + 10));

        loadData();

        startThread();
    }

    private void loadData() {
        bubble = new XYSeries("Bubble Sort");
        bubble2 = new XYSeries("Bubble Sort2");
        insertion = new XYSeries("Insertion Sort");
        selection = new XYSeries("Selection Sort");
        quick = new XYSeries("Quick Sort");
        merge = new XYSeries("Merge Sort");
    }

    public void startThread() {
        threadMain = new Thread(this);
        threadMain.start();
    }

    @Override
    public void run() {
        while (threadMain != null) {
            if (number == 1_000_000) break;
            update();
            repaint();
            try {
                Thread.sleep((long) (1000 / FPS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void update() {
        int[] array = createData();

        int[] arraySort = Arrays.copyOf(array, array.length);
        ISort bubbleSort = new BubbleSort();
        bubbleSort.sort(arraySort);
        bubble.add(number, bubbleSort.getTimes());

        arraySort = Arrays.copyOf(array, array.length);
        ISort insertionSort = new InsertionSort();
        insertionSort.sort(arraySort);
        insertion.add(number, insertionSort.getTimes());

        arraySort = Arrays.copyOf(array, array.length);
        ISort selectionSort = new SelectionSort();
        selectionSort.sort(arraySort);
        selection.add(number, selectionSort.getTimes());

        arraySort = Arrays.copyOf(array, array.length);
        ISort mergeSort = new MergeSort();
        mergeSort.sort(arraySort);
        merge.add(number, mergeSort.getTimes());

        arraySort = Arrays.copyOf(array, array.length);
        ISort quickSort = new QuickSort();
        quickSort.sort(arraySort);
        quick.add(number, quickSort.getTimes());
    }

    private int[] createData() {
        int[] array = new int[number += 1_000];
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(1_000_000);
        }
        return array;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(bubble);
        dataset.addSeries(bubble2);
        dataset.addSeries(insertion);
        dataset.addSeries(selection);
        dataset.addSeries(merge);
        dataset.addSeries(quick);


        JFreeChart chart = ChartFactory.createXYLineChart(
                nameChart,
                xAxis,
                yAxis,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(maxWidth, maxHeight));
        add(chartPanel);
    }
}
