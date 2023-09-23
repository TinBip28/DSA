package week2.sortstrategy;

public class InsertionSort implements ISort {
    private int swapCount;
    private int compareNums;
    private long times;

    public int getSwapCount() {
        return swapCount;
    }

    public long getTimes() {
        return times;
    }

    public int getCompareNums() {
        return compareNums;
    }

    @Override
    public void sort(int[] data) {
        long start = System.nanoTime();
        for (int i = 1; i < data.length; ++i) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                compareNums++;
                data[j + 1] = data[j];
                j = j - 1;
                swapCount++;
            }
            data[j + 1] = key;
            swapCount++;
        }
        long end = System.nanoTime();
        times = end - start;

    }

}
