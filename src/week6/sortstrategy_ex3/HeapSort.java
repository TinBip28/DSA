package week6.sortstrategy_ex3;

public class HeapSort implements ISort {
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
    public void sort(int[] arr) {
        long start, end;
        start = System.nanoTime();
        // Build heap (rearrange array)
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);

        // One by one extract an element from heap
        for (int i = arr.length - 1; i > 0; i--) {
            // Move current root to end
            swap(arr[0], arr[i]);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
            end = System.nanoTime();
            times = end - start;
        }
    }

    public void heapify(int arr[], int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest]) {
            compareNums++;
            largest = l;
        }
        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest]) {
            compareNums++;
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr[i], largest);

            // Recursively heapify the affected subtree
            heapify(arr, N, largest);
        }
    }

    public void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
        swapCount++;
    }
}
