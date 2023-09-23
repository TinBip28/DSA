package week2.sortstrategy;

public class QuickSort implements ISort {
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

    public void quickSort(int[] data, int l, int r) {
        int m = data[(l + r) / 2];
        int i = l, j = r;
        while (i < j) {
            while (data[i] < m) {
                i++;
                compareNums++;
            }
            while (data[j] > m) {
                j--;
                compareNums++;
            }
            if (i <= j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
                swapCount++;
            }
        }
        if (i < r) {
            quickSort(data, i, r);
        }
        if (l < j) {
            quickSort(data, l, j);
        }
    }

    @Override
    public void sort(int[] arr) {
        long start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        times = end - start;
    }
}
