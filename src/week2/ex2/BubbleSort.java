package week2.ex2;

public class BubbleSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public void sort(T[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j].compareTo(data[j+1]) > 0) {
                    T tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }
}