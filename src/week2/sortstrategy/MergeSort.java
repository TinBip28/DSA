package week2.sortstrategy;

public class MergeSort implements ISort {
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
    public void sort(int[] arr) {
        long start = System.nanoTime();
        sort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        times = end - start;
    }

    public void sort(int[] data, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(data, l, m);
            sort(data, m + 1, r);
            merge(data, l, m, r);
        }
    }

    public void merge(int[] data, int low, int mid, int high) {
        int n = high - low + 1;
        int[] b = new int[n];
        int left = low, right = mid + 1, bIdx = 0;
        while (left <= mid && right <= high) {
            if (data[left] <= data[right])
                b[bIdx++] = data[left++];
            else b[bIdx] = data[right++];
            swapCount++;
            compareNums++;
        }
        while (left <= mid) {
            b[bIdx++] = data[left++];
            swapCount++;
        }

        while (right <= high){
            b[bIdx++] = data[right++];
            swapCount++;
        }

        for (int k = 0; k < n; k++) {
            data[low + k] = b[k];
        }
    }
}
