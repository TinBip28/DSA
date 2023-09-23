package week2.sortstrategy;

public class SelectionSort implements ISort {
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
        for (int i = 0; i < data.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < data.length; j++) {
                compareNums++;
                if (data[j] < data[minIdx]) {
                    minIdx = j;
                }
                int temp = data[minIdx];
                data[minIdx] = data[i];
                data[i] = temp;
                swapCount++;
            }
        }
        long end = System.nanoTime();
        times = end - start;
    }


}
