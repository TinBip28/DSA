package week2.ex5;

public class QuickSort {
    public QuickSort() {
    }

    public void quickSort(long[] data, int l, int r) {
        long m = data[(l + r) / 2];
        int i = l, j = r;
        while (i < j) {
            while (data[i] < m) {
                i++;
            }
            while (data[j] > m) {
                j--;
            }
            if (i <= j) {
                long temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        if (i < r) {
            quickSort(data, i, r);
        }
        if (l < j) {
            quickSort(data, l, j);
        }
    }
}
