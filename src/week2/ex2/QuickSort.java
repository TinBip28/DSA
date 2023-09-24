package week2.ex2;

public class QuickSort<T extends Comparable<T>> implements ISort<T> {

    public void quickSort(T[] data, int l, int r) {
        T m = data[(l + r) / 2];
        int i = l, j = r;
        while (i < j) {
            while (data[i].compareTo(m) < 0) {
                i++;
            }
            while (data[j].compareTo(m) > 0) {
                j--;

            }
            if (i <= j) {
                T temp = data[i];
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

    @Override
    public void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
