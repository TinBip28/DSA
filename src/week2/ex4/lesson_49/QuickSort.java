package week2.ex4.lesson_49;

public class QuickSort {
    public QuickSort() {
    }

    public void quickSort(int[] data, int l, int r) {
        int m = data[(l + r) / 2];
        int i = l, j = r;
        while (i < j) {
            while (data[i] < m) {
                i++;
            }
            while (data[j] > m) {
                j--;
            }
            if (i <= j) {
                int temp = data[i];
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
