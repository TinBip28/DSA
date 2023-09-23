package week2.sortstrategy;

public class BubbleSort implements ISort {
    private int swapCount;
    private long times;
    private int compareNums;

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
        int n = data.length;
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                compareNums++;
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    swapCount++;
                }
            }
        }
        end = System.nanoTime();
        times = end - start;
    }
}