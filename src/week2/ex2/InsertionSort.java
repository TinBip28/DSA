package week2.ex2;

public class InsertionSort<T extends Comparable<T>> implements ISort<T> {
    @Override
    public void sort(T[] data) {
        for (int i = 1; i < data.length; ++i) {
            T key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j].compareTo(key) > 0) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }
}
